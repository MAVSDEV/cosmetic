package com.hm.cosmeticmarket.controllers.parsers;

import com.google.inject.Inject;
import com.hm.cosmeticmarket.models.Product;

import java.util.concurrent.Executor;

/**
 * Product parser from rest api request.
 */
public class ProductBodyParser extends AbstractBodyParser<Product> {
    @Inject
    public ProductBodyParser(Json jsonParser, Executor executor) {
        super(jsonParser, executor);
    }
}
