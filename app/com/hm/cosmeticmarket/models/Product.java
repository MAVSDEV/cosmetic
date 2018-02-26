package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.DbJson;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Product.
 */
@Data
@Entity(name = "product")
public class Product extends Model implements Serializable {

    @Id
    private Long id;
    private String url;
    private String name;
    private String briefDescription;
    private Integer price;
    private Integer overallRating;
    private String mainImage;
    private String brand;
    private String volume;
    private Date creationDate;

    @DbJson
    private List<String> otherImages;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductCategory productCategory;

    @DbJson
    private List<ProductProperty> properties;
    @DbJson
    private ProductDescription description;


    public static Finder<String, Product> find = new Finder<>(Product.class);
}