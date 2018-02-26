package com.hm.cosmeticmarket.models.sql;

import lombok.Getter;

/**
 * Sort type.
 */
@Getter
public enum SortType {

    PRICE("price"),
    NEWEST("newest");

    SortType(String name) {
        this.name = name;
    }

    private String name;

    public static SortType getByName(String name) {
        for (SortType sortType: values()) {
            if (name.equalsIgnoreCase(sortType.getName())) {
                return sortType;
            }
        }
        return NEWEST;
    }
}
