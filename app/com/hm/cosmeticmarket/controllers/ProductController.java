package com.hm.cosmeticmarket.controllers;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.controllers.parsers.ProductBodyParser;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.services.ProductService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Product Controller.
 */
@Singleton
public class ProductController extends Controller {

    @Inject
    private ProductService productService;

    public Result getById(String id) {
        Product product = productService.getById(id);
        return ok(Json.toJson(product));
    }

    public Result getAll() {
        List<Product> all = productService.getAll();
        return ok(Json.toJson(all));
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result save() {
        Product product = request().body().as(Product.class);
        productService.save(product);
        return ok("Product file was saved!");
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result update() {
        Product product = request().body().as(Product.class);
        productService.update(product);
        return ok("Product was updated!");
    }

    public Result delete(String id) {
        productService.remove(id);
        return ok("Product with id '" + id + "' was deleted!");
    }

    private Result getProductByProperty(String property, String value) {
        Product product = productService.getByParamName(property, value);
        return ok(Json.toJson(product));
    }
}
