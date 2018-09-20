package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class AskFormInfo extends Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String userName;
    private String message;
    private String phoneNumber;
    private String emailAddress;

    public static Finder<String, AskFormInfo> find = new Finder<>(AskFormInfo.class);
}
