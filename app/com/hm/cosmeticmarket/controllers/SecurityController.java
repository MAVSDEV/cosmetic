package com.hm.cosmeticmarket.controllers;

import play.mvc.Controller;
import play.mvc.Result;

//todo rework in new version
public class SecurityController extends Controller {

    public Result checkToken() {
        String accessToken = request().body().as(String.class);

        if("aloe-token!(*1789".equals(accessToken)) {
            return ok();
        }

        return unauthorized();
    }
}
