package com.hm.cosmeticmarket.repositiries;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.AskFormInfo;
import com.hm.cosmeticmarket.repositiries.impl.AskFormInfoRepositoryImpl;

/**
 * AskFormInfo Repository.
 */
@ImplementedBy(AskFormInfoRepositoryImpl.class)
public interface AskFormInfoRepository extends CommonRepository<AskFormInfo> {

}
