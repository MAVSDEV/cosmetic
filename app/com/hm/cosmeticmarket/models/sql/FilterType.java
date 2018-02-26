package com.hm.cosmeticmarket.models.sql;

import lombok.Getter;

import java.util.Optional;

/**
 * Filter type.
 */
@Getter
public enum FilterType {

    CATEGORY("category");

    FilterType(String name) {
        this.name = name;
    }

    private String name;

    public static Optional<FilterType> getByName(String name) {
        for (FilterType sortType: values()) {
            if (name.equalsIgnoreCase(sortType.getName())) {
                return Optional.of(sortType);
            }
        }
        return Optional.empty();
    }
}
