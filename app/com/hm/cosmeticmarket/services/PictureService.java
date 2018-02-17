package com.hm.cosmeticmarket.services;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Picture;
import com.hm.cosmeticmarket.services.impl.PictureServiceImpl;

/**
 * Picture Service.
 */
@ImplementedBy(PictureServiceImpl.class)
public interface PictureService extends CommonService<Picture> {}
