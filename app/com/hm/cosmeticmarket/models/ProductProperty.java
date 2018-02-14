package com.hm.cosmeticmarket.models;

import lombok.Data;

import java.util.List;

/**
 * Product Property.
 */
@Data
public class ProductProperty {
    private String name;
    private List<String> values;
}
