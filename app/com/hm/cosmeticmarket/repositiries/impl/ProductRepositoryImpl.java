package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.repositiries.ProductRepository;

import java.util.List;

/**
 * Implementation of {@link ProductRepository}
 */
@Singleton
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getAll() {
        return Product.find.all();
    }

    @Override
    public Product getById(String productId) {
        return Product.find.byId(productId);
    }

    @Override
    public Product getByParamName(String paramName, String value) {
        return Product.find.query().where().eq(paramName, value).findUnique();
    }

    @Override
    public void save(Product product) {
        Product.db().save(product);
    }

    @Override
    public void update(Product product) {
        Product.db().update(product);
    }

    @Override
    public void remove(String productId) {
        Product.find.deleteById(productId);
    }
}
