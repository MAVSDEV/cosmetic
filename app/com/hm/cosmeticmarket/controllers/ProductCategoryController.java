package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.services.ProductCategoryService;
import play.libs.Json;
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

    public Result getByCategoryId(String id) {
        return ok(Json.toJson(productCategoryService.getProductsByCategoryId(id)));
    }
}
