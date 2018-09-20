package com.hm.cosmeticmarket.providers;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.providers.impl.EmailProviderImpl;
import play.libs.mailer.Email;

/**
 * Sends emails.
 */
@ImplementedBy(EmailProviderImpl.class)
public interface EmailProvider {
    /**
     * Sends email message.
     *
     * @param email email to be sent.
     */
    void sendEmail(Email email);

    void sendEmail(String subject, String bodyText);

}