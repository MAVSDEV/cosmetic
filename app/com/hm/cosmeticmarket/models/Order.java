package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class Order extends Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private boolean selfPickup;
    private String address;

    private Date dateOfDelivery;
    private String comments;



    private String userName;
    private String message;
    private String phoneNumber;
    private String emailAddress;

    public static Finder<String, Order> find = new Finder<>(Order.class);
}
