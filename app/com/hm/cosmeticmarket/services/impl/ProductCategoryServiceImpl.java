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
public class ProductCategoryServiceImpl extends AbstractServiceImpl<ProductCategory> implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Inject
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository);
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        return productCategoryRepository.getProductsByCategoryId(categoryId);
    }
}
