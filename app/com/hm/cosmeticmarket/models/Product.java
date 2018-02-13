package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.DbJson;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private String briefDescription;
    private Integer price;
    private String directions;
    private Integer overallRating;
    private String mainImage;
    private String brand;

    @DbJson
    private List<String> otherImages;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductCategory category;

    @DbJson
    private List<ProductProperty> productProperty;
    @DbJson
    private ProductDescription productDescription;


    public static Finder<String, Product> find = new Finder<>(Product.class);
}