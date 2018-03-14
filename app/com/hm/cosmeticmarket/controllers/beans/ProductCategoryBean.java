package com.hm.cosmeticmarket.controllers.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product Category Rest Bean.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryBean {
    private Long id;
    private String name;
    private long products;
}
