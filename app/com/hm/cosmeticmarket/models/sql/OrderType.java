package com.hm.cosmeticmarket.models.sql;

import lombok.Getter;

/**
 * Order type.
 */
@Getter
public enum OrderType {

    ASC("asc"),
    DESC("desc");

    OrderType(String name) {
        this.name = name;
    }

    private String name;

    public static OrderType getByName(String name) {
        for (OrderType orderType: values()) {
            if (name.equalsIgnoreCase(orderType.getName())) {
                return orderType;
            }
        }
        return DESC;
    }
}
