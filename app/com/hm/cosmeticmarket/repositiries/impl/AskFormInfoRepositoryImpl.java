package com.hm.cosmeticmarket.repositiries.impl;

import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.AskFormInfo;
import com.hm.cosmeticmarket.repositiries.AskFormInfoRepository;
import io.ebean.Finder;

/**
 * Implementation of {@link AskFormInfoRepository}.
 */
@Singleton
public class AskFormInfoRepositoryImpl extends AbstractRepositoryImpl<AskFormInfo> implements AskFormInfoRepository {

    @Override
    protected Finder<String, AskFormInfo> finder() {
        return AskFormInfo.find;
    }
}
