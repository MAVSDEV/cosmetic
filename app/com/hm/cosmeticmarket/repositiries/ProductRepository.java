package com.hm.cosmeticmarket.repositiries;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.repositiries.impl.ProductRepositoryImpl;

/**
 * Product Repository.
 */
@ImplementedBy(ProductRepositoryImpl.class)
public interface ProductRepository extends CommonRepository<Product> {

}
