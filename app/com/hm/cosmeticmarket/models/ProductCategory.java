package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Product Category.
 */
@Data
@Entity(name = "product_category")
public class ProductCategory extends Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    public static Finder<String, ProductCategory> find = new Finder<>(ProductCategory.class);
}
