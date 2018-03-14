package com.hm.cosmeticmarket.repositiries;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.sql.OrderType;
import com.hm.cosmeticmarket.models.sql.SortType;
import com.hm.cosmeticmarket.repositiries.impl.ProductRepositoryImpl;

import java.util.List;
import java.util.Map;

/**
 * Product Repository.
 */
@ImplementedBy(ProductRepositoryImpl.class)
public interface ProductRepository extends CommonRepository<Product> {

    List<Product> getAll(SortType sortType, OrderType sortOrder, Map<String, String> filterMap);

    List<Product> search(String searchTerm, SortType sortType, OrderType sortOrder, Map<String, String> filterMap);

    long getProductsCountByCategoryName(String name);
}
