package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.repositiries.ProductCategoryRepository;
import io.ebean.Finder;

/**
 * Implementation of {@link ProductCategoryRepository}.
 */
@Singleton
public class ProductCategoryRepositoryImpl extends AbstractRepositoryImpl<ProductCategory> implements ProductCategoryRepository {

    @Override
    protected Finder<String, ProductCategory> finder() {
        return ProductCategory.find;
    }

    @Override
    public Integer getCountOfAllCategories() {
        return ProductCategory.find.all().size();
    }
}
