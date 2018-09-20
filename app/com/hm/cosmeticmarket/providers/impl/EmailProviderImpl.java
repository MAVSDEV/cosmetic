package com.hm.cosmeticmarket.providers.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.providers.EmailProvider;
import play.api.libs.mailer.MailerClient;
import play.libs.mailer.Email;

/**
 * Implementation of {@link EmailProvider}
 */
@Singleton
public class EmailProviderImpl implements EmailProvider {

    private final MailerClient mailer;

    private static final String SYSTEM_EMAIL_ADDRESS = "event.of.dream.info@gmail.com";

    @Inject
    public EmailProviderImpl(MailerClient mailer){
        this.mailer = mailer;
    }

    @Override
    public void sendEmail(Email email) {
        mailer.send(email);
    }

    @Override
    public void sendEmail(String subject, String bodyText) {
        Email email = new Email()
                .setSubject(subject)
                .setFrom(SYSTEM_EMAIL_ADDRESS)
                .addTo(SYSTEM_EMAIL_ADDRESS)
                .setBodyText(bodyText);
        mailer.send(email);
    }
}
