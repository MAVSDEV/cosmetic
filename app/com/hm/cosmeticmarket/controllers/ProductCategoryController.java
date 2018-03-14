package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.controllers.beans.ProductCategoryBean;
import com.hm.cosmeticmarket.controllers.parsers.ProductCategoryBodyParser;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.services.ProductCategoryService;
import com.hm.cosmeticmarket.services.ProductService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Product Category Controller.
 */
@Singleton
public class ProductCategoryController extends AbstractController<ProductCategory> {

    private final ProductCategoryService productCategoryService;

    private final ProductService productService;

    @Inject
    public ProductCategoryController(ProductCategoryService productCategoryService, ProductService productService) {
        super(productCategoryService, ProductCategory.class);
        this.productCategoryService = productCategoryService;
        this.productService = productService;
    }

    public Result getAll() {
        List<ProductCategoryBean> productCategoryBeans = productCategoryService.getAll().stream()
                .map(pc -> new ProductCategoryBean(pc.getName(), productService.getProductsCountByCategoryName(pc.getName())))
                .collect(Collectors.toList());
        return ok(Json.toJson(productCategoryBeans));
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
