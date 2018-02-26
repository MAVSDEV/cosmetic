package com.hm.cosmeticmarket.controllers;

import com.hm.cosmeticmarket.services.CommonService;
import play.libs.Json;
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

    public Result save(T t) {
        commonService.save(t);
        return ok(type.getSimpleName() + " object was saved!");
    }

    public Result update() {
        commonService.update(request().body().as(type));
        return ok("Object was updated!");
    }

    public Result delete(String id) {
        commonService.remove(id);
        return ok(type.getSimpleName() + " with id '" + id + "' was deleted!");
    }

    private Result getProductByProperty(String property, String value) {
        return ok(Json.toJson(commonService.getByParamName(property, value)));
    }
}
