package com.hm.cosmeticmarket.services;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.services.impl.ProductServiceImpl;

import java.util.List;

/**
 * Product Service.
 */
@ImplementedBy(ProductServiceImpl.class)
public interface ProductService {

    List<Product> getAll();

    Product getById(String productId);

    Product getByParamName(String paramName, String value);

    void save(Product product);

    void update(Product product);

    void remove(String productId);
}
