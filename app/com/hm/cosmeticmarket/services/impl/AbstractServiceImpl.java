package com.hm.cosmeticmarket.services.impl;

import com.hm.cosmeticmarket.repositiries.CommonRepository;
import com.hm.cosmeticmarket.services.CommonService;

import java.util.List;

/**
 * Abstract Service Implementation.
 */
public abstract class AbstractServiceImpl<T> implements CommonService<T> {

    private final CommonRepository<T> commonRepository;

    public AbstractServiceImpl(CommonRepository<T> commonRepository) {
        this.commonRepository = commonRepository;
    }

    @Override
    public List<T> getAll() {
        return commonRepository.getAll();
    }

    @Override
    public T getById(String objectId) {
        return commonRepository.getById(objectId);
    }

    @Override
    public T getByParamName(String paramName, String value) {
        return commonRepository.getByParamName(paramName, value);
    }

    @Override
    public void save(T object) {
        commonRepository.save(object);
    }

    @Override
    public void update(T object) {
        commonRepository.update(object);
    }

    @Override
    public void remove(String objectId) {
        commonRepository.remove(objectId);
    }
}
