package com.hm.cosmeticmarket.models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import play.mvc.Http;

import javax.persistence.Entity;

/**
 * Image.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Picture extends Model {

    private String pictureId;
    private Http.MultipartFormData.FilePart<Object> image;
    private String productId;

    public static Finder<String, Picture> find = new Finder<>(Picture.class);
}