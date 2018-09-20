package com.hm.cosmeticmarket.controllers.parsers;

import com.google.inject.Inject;
import com.hm.cosmeticmarket.models.AskFormInfo;

import java.util.concurrent.Executor;

/**
 * AskFormInfo parser from rest api request.
 */
public class AskFormInfoParser extends AbstractBodyParser<AskFormInfo> {
    @Inject
    public AskFormInfoParser(Json jsonParser, Executor executor) {
        super(jsonParser, executor);
    }
}
