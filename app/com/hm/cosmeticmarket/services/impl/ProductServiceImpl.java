package com.hm.cosmeticmarket.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.repositiries.ProductRepository;
import com.hm.cosmeticmarket.services.ProductService;

/**
 * Implementation of {@link ProductService}
 */
@Singleton
public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }
}
