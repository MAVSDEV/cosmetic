package com.hm.cosmeticmarket.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.repositiries.ProductCategoryRepository;
import com.hm.cosmeticmarket.services.ProductCategoryService;
import com.hm.cosmeticmarket.services.ProductService;

import java.util.List;

/**
 * Implementation of {@link ProductService}.
 */
@Singleton
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Inject
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.getAll();
    }

    @Override
    public ProductCategory getById(String objectId) {
        return productCategoryRepository.getById(objectId);
    }

    @Override
    public ProductCategory getByParamName(String paramName, String value) {
        return productCategoryRepository.getByParamName(paramName, value);
    }

    @Override
    public void save(ProductCategory object) {
        productCategoryRepository.save(object);
    }

    @Override
    public void update(ProductCategory object) {
        productCategoryRepository.update(object);
    }

    @Override
    public void remove(String objectId) {
        productCategoryRepository.remove(objectId);
    }

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        return productCategoryRepository.getProductsByCategoryId(categoryId);
    }
}
