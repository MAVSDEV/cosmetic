package com.hm.cosmeticmarket.repositiries.impl;

import com.hm.cosmeticmarket.repositiries.CommonRepository;
import io.ebean.Finder;
import io.ebean.Model;

import java.util.List;

/**
 * Abstract Repository Implementation.
 */
public abstract class AbstractRepositoryImpl<T extends Model> implements CommonRepository<T> {

    @Override
    public List<T> getAll() {
        return finder().all();
    }

    @Override
    public T getById(String objectId) {
        return finder().byId(objectId);
    }

    @Override
    public T getByParamName(String paramName, String value) {
        return finder().query().where().eq(paramName, value).findUnique();
    }

    @Override
    public void save(T object) {
        Model.db().save(object);
    }

    @Override
    public void update(T object) {
        Model.db().update(object);
    }

    @Override
    public void remove(String objectId) {
        finder().deleteById(objectId);
    }
    
    protected abstract Finder<String, T> finder();
}
