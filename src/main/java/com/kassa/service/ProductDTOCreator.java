package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;

@FunctionalInterface
public interface ProductDTOCreator {
    ProductDTO converter(Product product);

    static ProductDTO from(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .amount(product.getAmount())
                .build();
    }
}
