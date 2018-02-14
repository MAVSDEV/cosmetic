package com.hm.cosmeticmarket.repositiries.impl;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.repositiries.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link ProductCategoryRepository}.
 */
@Singleton
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    @Override
    public List<ProductCategory> getAll() {
        return ProductCategory.find.all();
    }

    @Override
    public ProductCategory getById(String objectId) {
        return ProductCategory.find.byId(objectId);
    }

    @Override
    public ProductCategory getByParamName(String paramName, String value) {
        return ProductCategory.find.query().where().eq(paramName, value).findUnique();
    }

    @Override
    public void save(ProductCategory object) {
        ProductCategory.db().save(object);
    }

    @Override
    public void update(ProductCategory object) {
        ProductCategory.db().update(object);
    }

    @Override
    public void remove(String objectId) {
        ProductCategory.find.deleteById(objectId);
    }

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        List<Product> products = Lists.newArrayList();
        Optional.ofNullable(ProductCategory.find.byId(categoryId))
                .ifPresent(productCategory -> products.addAll(productCategory.getProducts()));
        return products;
    }
}
