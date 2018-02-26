package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.controllers.parsers.ProductCategoryBodyParser;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.services.ProductCategoryService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Product Category Controller.
 */
@Singleton
public class ProductCategoryController extends AbstractController<ProductCategory> {

    private final ProductCategoryService productCategoryService;

    @Inject
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        super(productCategoryService, ProductCategory.class);
        this.productCategoryService = productCategoryService;
    }

    public Result getCountOfAllCategories() {
        return ok(productCategoryService.getCountOfAllCategories().toString());
    }

    @BodyParser.Of(ProductCategoryBodyParser.class)
    public Result save() {
        return super.save(request().body().as(ProductCategory.class));
    }

    @BodyParser.Of(ProductCategoryBodyParser.class)
    public Result update() {
        return super.update();
    }

    public Result getByCategoryId(String id) {
        return ok(Json.toJson(productCategoryService.getProductsByCategoryId(id)));
    }
}
