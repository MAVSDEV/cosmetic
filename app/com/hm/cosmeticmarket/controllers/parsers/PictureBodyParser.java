package com.hm.cosmeticmarket.controllers.parsers;

import com.google.inject.Inject;
import com.hm.cosmeticmarket.models.Picture;

import java.util.concurrent.Executor;

/**
 * Picture parser from rest api request.
 */
public class PictureBodyParser extends AbstractBodyParser<Picture> {
    @Inject
    public PictureBodyParser(Json jsonParser, Executor executor) {
        super(jsonParser, executor);
    }
}
