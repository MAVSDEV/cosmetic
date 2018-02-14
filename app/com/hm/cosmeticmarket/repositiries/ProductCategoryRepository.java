package com.hm.cosmeticmarket.repositiries;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.ProductCategory;
import com.hm.cosmeticmarket.repositiries.impl.ProductCategoryRepositoryImpl;

import java.util.List;

/**
 * Product Category Repository.
 */
@ImplementedBy(ProductCategoryRepositoryImpl.class)
public interface ProductCategoryRepository extends CommonRepository<ProductCategory> {

    List<Product> getProductsByCategoryId(String categoryId);
}
