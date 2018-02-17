package com.hm.cosmeticmarket.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Picture;
import com.hm.cosmeticmarket.repositiries.PictureRepository;
import com.hm.cosmeticmarket.services.PictureService;

/**
 * Implementation of {@link PictureService}
 */
@Singleton
public class PictureServiceImpl extends AbstractServiceImpl<Picture> implements PictureService {

    @Inject
    public PictureServiceImpl(PictureRepository pictureRepository) {
        super(pictureRepository);
    }
}