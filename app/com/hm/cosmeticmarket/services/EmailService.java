package com.hm.cosmeticmarket.services;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.AskFormInfo;
import com.hm.cosmeticmarket.services.impl.EmailServiceImpl;

/**
 * Email Service.
 */
@ImplementedBy(EmailServiceImpl.class)
public interface EmailService {

    void processAskFormEmail(AskFormInfo askFormInfo);
}
