package com.hm.cosmeticmarket.services;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.sql.OrderType;
import com.hm.cosmeticmarket.models.sql.SortType;
import com.hm.cosmeticmarket.services.impl.ProductServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * Product Service.
 */
@ImplementedBy(ProductServiceImpl.class)
public interface ProductService extends CommonService<Product> {

    List<Product> search(String searchTerm, SortType sortType, OrderType sortOrder, Map<String, String> filterMap);

    Integer getProductsCountByCategoryId(Long id);
}
