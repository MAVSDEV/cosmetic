package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.repositiries.ProductRepository;
import io.ebean.Finder;

/**
 * Implementation of {@link ProductRepository}
 */
@Singleton
public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product> implements ProductRepository {

    @Override
    protected Finder<String, Product> finder() {
        return Product.find;
    }
}
