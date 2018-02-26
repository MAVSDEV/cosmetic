package com.hm.cosmeticmarket.utils;

/**
 * Class for common util methods
 */
public class CommonUtils {

    /**
     * check value and return value or default value if value is null
     *
     * @param val          value to
     * @param defaultValue returned value if {@param val} is null
     * @return {@param val} if not null or {@param defaultValue} if {@param val} is null
     */
    public static <T> T getOrDefault(T val, T defaultValue) {
        return val != null ? val : defaultValue;
    }
}
