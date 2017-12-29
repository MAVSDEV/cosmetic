package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Product.
 */
@Data
@Entity
public class Product extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String url;
    private String name;
    private String description;

    public static Finder<String, Product> find = new Finder<>(Product.class);
}