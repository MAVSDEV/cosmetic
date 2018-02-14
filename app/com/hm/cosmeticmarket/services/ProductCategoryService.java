package com.hm.cosmeticmarket.services;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.services.impl.ProductCategoryServiceImpl;

import java.util.List;

/**
 * Product Category Service.
 */
@ImplementedBy(ProductCategoryServiceImpl.class)
public interface ProductCategoryService extends CommonService<ProductCategory> {

    List<Product> getProductsByCategoryId(String categoryId);
}
