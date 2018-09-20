package com.hm.cosmeticmarket.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.AskFormInfo;
import com.hm.cosmeticmarket.providers.EmailProvider;
import com.hm.cosmeticmarket.repositiries.AskFormInfoRepository;
import com.hm.cosmeticmarket.services.EmailService;

/**
 * Implementation of {@link EmailService}.
 */
@Singleton
public class EmailServiceImpl implements EmailService {

    private static final String SUBJECT_OF_ASK_FORM = "[AloePlus] :: Ask form information!";

    @Inject
    private EmailProvider emailProvider;

    @Inject
    private AskFormInfoRepository askFormInfoRepository;

    @Override
    public void processAskFormEmail(AskFormInfo askFormInfo) {
        askFormInfoRepository.save(askFormInfo);
        emailProvider.sendEmail(SUBJECT_OF_ASK_FORM, buildEmailMessage(askFormInfo));
    }

    private String buildEmailMessage(AskFormInfo askFormInfo) {
        return new StringBuilder()
                .append(askFormInfo.getUserName())
                .append(" задал следующий вопрос: ")
                .append(askFormInfo.getMessage())
                .append(". \n Емейл адрес: ")
                .append(askFormInfo.getEmailAddress())
                .append(". \n номер телефона: ")
                .append(askFormInfo.getPhoneNumber()).toString();

    }
}
