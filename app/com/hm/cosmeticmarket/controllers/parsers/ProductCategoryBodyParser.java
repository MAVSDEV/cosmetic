package com.hm.cosmeticmarket.controllers.parsers;

import com.google.inject.Inject;
import com.hm.cosmeticmarket.models.ProductCategory;

import java.util.concurrent.Executor;

/**
 * Product Category parser from rest api request.
 */
public class ProductCategoryBodyParser extends AbstractBodyParser<ProductCategory> {
    @Inject
    public ProductCategoryBodyParser(Json jsonParser, Executor executor) {
        super(jsonParser, executor);
    }
}
