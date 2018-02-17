package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.controllers.parsers.PictureBodyParser;
import com.hm.cosmeticmarket.models.Picture;
import com.hm.cosmeticmarket.services.PictureService;
import lombok.extern.slf4j.Slf4j;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

/**
 * Picture Controller.
 */
@Slf4j
@Singleton
public class PictureController extends AbstractController<Picture> {

    private static final String IMAGE_FILE_NAME = "image";
    private static final String PICTURE_ID_PARAM = "pictureId";
    private static final String PRODUCT_ID_PARAM = "productId";

    @Inject
    public PictureController(PictureService pictureService) {
        super(pictureService, Picture.class);
    }

    public Result save() {
        log.warn("Start upload image!");
        Http.MultipartFormData<Object> multipartFormData = request().body().asMultipartFormData();
        Map<String, String[]> bodyMap = multipartFormData.asFormUrlEncoded();

        String pictureId = bodyMap.get(PICTURE_ID_PARAM)[0];
        String productId = bodyMap.get(PRODUCT_ID_PARAM)[0];
        Http.MultipartFormData.FilePart<Object> image = multipartFormData.getFile(IMAGE_FILE_NAME);
        return super.save(new Picture(pictureId, image, productId));
    }

    @BodyParser.Of(PictureBodyParser.class)
    public Result update() {
        return super.update();
    }
}
