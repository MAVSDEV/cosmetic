package com.hm.cosmeticmarket.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.repositiries.ProductRepository;
import com.hm.cosmeticmarket.services.ProductService;

import java.util.List;

/**
 * Implementation of {@link ProductService}
 */
@Singleton
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(String productId) {
        return productRepository.getById(productId);
    }

    @Override
    public Product getByParamName(String paramName, String value) {
        return productRepository.getByParamName(paramName, value);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(String productId) {
        productRepository.remove(productId);
    }
}
