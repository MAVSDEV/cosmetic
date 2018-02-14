package com.hm.cosmeticmarket.controllers;

import com.hm.cosmeticmarket.controllers.parsers.ProductBodyParser;
import com.hm.cosmeticmarket.services.CommonService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Abstract Controller.
 */
public abstract class AbstractController <T> extends Controller {

    private final Class<T> type;
    private final CommonService<T> commonService;

    public AbstractController(CommonService<T> commonService, Class<T> type) {
        this.commonService = commonService;
        this.type = type;
    }

    public Result getById(String id) {
        return ok(Json.toJson(commonService.getById(id)));
    }

    public Result getAll() {
        return ok(Json.toJson(commonService.getAll()));
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result save() {
        commonService.save(request().body().as(type));
        return ok(type + " file was saved!");
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result update() {
        commonService.update(request().body().as(type));
        return ok("Product was updated!");
    }

    public Result delete(String id) {
        commonService.remove(id);
        return ok(type + " with id '" + id + "' was deleted!");
    }

    private Result getProductByProperty(String property, String value) {
        return ok(Json.toJson(commonService.getByParamName(property, value)));
    }
}
