package com.hm.cosmeticmarket.controllers;

import com.hm.cosmeticmarket.controllers.parsers.AskFormInfoParser;
import com.hm.cosmeticmarket.models.AskFormInfo;
import com.hm.cosmeticmarket.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class EmailController extends Controller {

    @Inject
    private EmailService emailService;

    @BodyParser.Of(AskFormInfoParser.class)
    public Result processAskFormEmail() {
        AskFormInfo askFormInfo = request().body().as(AskFormInfo.class);
        log.info("Ask form data will be processed: {}", askFormInfo);
        emailService.processAskFormEmail(askFormInfo);
        return ok(Json.toJson("ask info was processed!"));
    }

//    public Result processOrderEmail() {
//
//    }
}
