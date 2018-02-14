package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Product Category.
 */
@Data
@Entity(name = "product_category")
public class ProductCategory extends Model {

    @Id
    @GeneratedValue
    private String id;
    private String name;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Product> products;

    public static Finder<String, ProductCategory> find = new Finder<>(ProductCategory.class);
}
