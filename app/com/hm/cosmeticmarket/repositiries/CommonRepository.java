package com.hm.cosmeticmarket.repositiries;

import java.util.List;

/**
 * Common Repository.
 */
public interface CommonRepository<T> {

    List<T> getAll();

    T getById(String objectId);

    T getByParamName(String paramName, String value);

    void save(T object);

    void update(T object);

    void remove(String objectId);
}
