package com.hm.cosmeticmarket.repositiries.impl;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.repositiries.ProductCategoryRepository;
import io.ebean.Finder;

import java.util.List;

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

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        List<Product> products = Lists.newArrayList();
//        Optional.ofNullable(ProductCategory.find.byId(categoryId))
//                .ifPresent(productCategory -> products.addAll(productCategory.getProducts()));
        return products;
    }
}
