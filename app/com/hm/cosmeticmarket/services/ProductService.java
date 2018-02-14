package com.hm.cosmeticmarket.services;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.services.impl.ProductServiceImpl;

/**
 * Product Service.
 */
@ImplementedBy(ProductServiceImpl.class)
public interface ProductService extends CommonService<Product> {

}
