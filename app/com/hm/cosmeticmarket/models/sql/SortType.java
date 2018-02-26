package com.hm.cosmeticmarket.models.sql;

import lombok.Getter;

/**
 * Sort type.
 */
@Getter
public enum SortType {

    PRICE("price", "price"),
    NEWEST("newest", "creation_date");

    SortType(String name, String columnName) {
        this.name = name;
        this.columnName = columnName;
    }

    private String name;
    private String columnName;

    public static SortType getByName(String name) {
        for (SortType sortType: values()) {
            if (name.equalsIgnoreCase(sortType.getName())) {
                return sortType;
            }
        }
        return NEWEST;
    }
}
