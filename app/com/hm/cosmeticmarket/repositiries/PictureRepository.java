package com.hm.cosmeticmarket.repositiries;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Picture;
import com.hm.cosmeticmarket.repositiries.impl.PictureRepositoryImpl;

/**
 * Picture Repository.
 */
@ImplementedBy(PictureRepositoryImpl.class)
public interface PictureRepository extends CommonRepository<Picture> {

}