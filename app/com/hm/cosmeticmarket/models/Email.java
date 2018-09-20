package com.hm.cosmeticmarket.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Email {

    private String id;
    private String subject;
    private String from;
    private String bodyText;
    private String bodyHtml;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String replyTo;
    private String bounceAddress;
    private String charset;
    private Map<String, String> headers;
}
