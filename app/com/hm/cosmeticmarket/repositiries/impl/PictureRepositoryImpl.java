package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Picture;
import com.hm.cosmeticmarket.repositiries.PictureRepository;
import io.ebean.Finder;

/**
 * Implementation of {@link PictureRepository}
 */
@Singleton
public class PictureRepositoryImpl extends AbstractRepositoryImpl<Picture> implements PictureRepository {

    @Override
    protected Finder<String, Picture> finder() {
        return Picture.find;
    }
}
