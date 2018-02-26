package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.sql.FilterType;
import com.hm.cosmeticmarket.models.sql.OrderType;
import com.hm.cosmeticmarket.models.sql.SortType;
import com.hm.cosmeticmarket.repositiries.ProductRepository;
import io.ebean.ExpressionList;
import io.ebean.Finder;

import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link ProductRepository}
 */
@Singleton
public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product> implements ProductRepository {

    private static final String NAME_PROPERTY = "name";
    private static final String BRIEF_DESCRIPTION = "brief_description";
    private static final String PRODUCT_CATEGORY = "product_category";

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
        ExpressionList<Product> productExpressionList = prepareWhereCondition();
        addFiltersToExpressionList(productExpressionList, filterMap);
        return productExpressionList
                .or()
                .ilike("t1." + NAME_PROPERTY, searchTermFormat)
                .ilike(NAME_PROPERTY, searchTermFormat)
                .ilike(BRIEF_DESCRIPTION, searchTermFormat)
                .orderBy(sortType.getColumnName() + " " + sortOrder.getName())
                .findList();
    }

    private ExpressionList<Product> prepareWhereCondition() {
        return Product.find.query().select("*")
                .fetch("productCategory")
                .where();
    }

    private void addFiltersToExpressionList(ExpressionList<Product> expressionList, Map<String, String> filterMap) {
        if (filterMap != null && !filterMap.isEmpty()) {
            expressionList.ieq("t1." + NAME_PROPERTY, filterMap.get(FilterType.CATEGORY.getName()));
        }
    }
}
