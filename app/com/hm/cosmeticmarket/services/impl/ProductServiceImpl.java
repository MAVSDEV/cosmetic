package com.hm.cosmeticmarket.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.sql.OrderType;
import com.hm.cosmeticmarket.models.sql.SortType;
import com.hm.cosmeticmarket.repositiries.ProductRepository;
import com.hm.cosmeticmarket.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link ProductService}
 */
@Slf4j
@Singleton
public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> search(String searchTerm, SortType sortType, OrderType sortOrder, Map<String, String> filterMap) {
        log.warn("-- search products. searchTerm: " + searchTerm + ", sortType: " + sortType +
                ", sortOrder: " + sortOrder + ", filterMap: " + filterMap);
        return StringUtils.isNotBlank(searchTerm) ? productRepository.search(searchTerm, sortType, sortOrder, filterMap)
                : productRepository.getAll(sortType, sortOrder, filterMap);
    }

    @Override
    public Integer getProductsCountByCategoryId(Long id) {
        return productRepository.getProductsCountByCategoryId(id);
    }
}
