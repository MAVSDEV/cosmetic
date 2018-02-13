package com.hm.cosmeticmarket.repositiries;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.repositiries.impl.ProductRepositoryImpl;

import java.util.List;

/**
 * Product Repository.
 */
@ImplementedBy(ProductRepositoryImpl.class)
public interface ProductRepository {

    List<Product> getAll();

    Product getById(String productId);

    Product getByParamName(String paramName, String value);

    /**
     * Save Product
     * @param product {@link Product}
     */
    void save(Product product);

    void update(Product product);

    void remove(String productId);

}
