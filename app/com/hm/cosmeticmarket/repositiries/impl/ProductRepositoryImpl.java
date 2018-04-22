package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.sql.OrderType;
import com.hm.cosmeticmarket.models.sql.SortType;
import com.hm.cosmeticmarket.repositiries.ProductRepository;
import io.ebean.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ProductRepository}
 */
@Slf4j
@Singleton
public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product> implements ProductRepository {

    private static final String ID_PROPERTY = "id";
    private static final String NAME_PROPERTY = "name";
    private static final String BRIEF_DESCRIPTION = "brief_description";
    private static final String PRODUCT_CATEGORY_ID = "product_category_id";

    @Override
    protected Finder<String, Product> finder() {
        return Product.find;
    }

    @Override
    public List<Product> getAll(SortType sortType, OrderType sortOrder, Map<String, String> filterMap) {
        ExpressionList<Product> productExpressionList = prepareWhereCondition();
        addFiltersToExpressionList(productExpressionList, filterMap);
        return productExpressionList
                .orderBy(sortType.getColumnName() + " " + sortOrder.getName())
                .findList();
    }

    @Override
    public List<Product> search(String searchTerm, SortType sortType, OrderType sortOrder, Map<String, String> filterMap) {
        String searchTermFormat = "%" + searchTerm + "%";
        log.warn("-----searchTermFormat: " + searchTermFormat);
        ExpressionList<Product> productExpressionList = prepareWhereCondition();
        addFiltersToExpressionList(productExpressionList, filterMap);
        return productExpressionList
                .disjunction()
                .ilike("t1." + NAME_PROPERTY, searchTermFormat)
                .ilike(NAME_PROPERTY, searchTermFormat)
                .ilike(BRIEF_DESCRIPTION, searchTermFormat)
                .orderBy(sortType.getColumnName() + " " + sortOrder.getName())
                .findList();
    }

    @Override
    public Integer getProductsCountByCategoryId(Long id) {
        return getProductsByCategoryId(id).size();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return Product.find.query().where()
                .eq(PRODUCT_CATEGORY_ID, id)
                .findList();
    }

    @Override
    public void remove(String objectId) {
        String sql = "DELETE FROM product WHERE id = :id";
        SqlUpdate update = Ebean.createSqlUpdate(sql);
        update.setParameter("id", Long.parseLong(objectId));
        Product.db().execute(update);
    }

    private ExpressionList<Product> prepareWhereCondition() {
        return Product.find.query().select("*")
                .fetch("productCategory")
                .where();
    }

    private void addFiltersToExpressionList(ExpressionList<Product> expressionList, Map<String, String> filterMap) {
        if (filterMap != null && !filterMap.isEmpty()) {
            filterMap.forEach((key, value) -> expressionList.in("t1." + ID_PROPERTY,
                    Arrays.stream(value.split(",")).map(Long::valueOf).collect(Collectors.toList())));
        }
    }
}
