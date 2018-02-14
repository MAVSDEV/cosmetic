package com.hm.cosmeticmarket.services;

import java.util.List;

/**
 * Common Service.
 */
public interface CommonService<T> {

    List<T> getAll();

    T getById(String objectId);

    T getByParamName(String paramName, String value);

    void save(T object);

    void update(T object);

    void remove(String objectId);
}
