package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.services.ProductService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Product Controller.
 */
@Singleton
public class ProductController extends AbstractController<Product> {

    @Inject
    public ProductController(ProductService productService) {
        super(productService, Product.class);
    }
}
