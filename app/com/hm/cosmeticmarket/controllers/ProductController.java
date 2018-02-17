package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.controllers.parsers.ProductBodyParser;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Product Controller.
 */
@Slf4j
@Singleton
public class ProductController extends AbstractController<Product> {

    private static final String DEFAULT_PRODUCT_IMAGE = "default-store-350x350.jpg";
    private static final String PRODUCT_IMAGE_PATH = "/assets/images/products/";

    @Inject
    public ProductController(ProductService productService) {
        super(productService, Product.class);
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result save() {
        Product product = request().body().as(Product.class);
        product.setMainImage(PRODUCT_IMAGE_PATH + DEFAULT_PRODUCT_IMAGE);
        return super.save(product);
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result update() {
        return super.update();
    }
}
