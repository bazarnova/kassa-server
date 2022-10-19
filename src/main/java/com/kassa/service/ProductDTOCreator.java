package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;

@FunctionalInterface
public interface ProductDTOCreator {
    ProductDTO converter(Product product);

    static ProductDTO from(Product product) {
        return new ProductDTO.Builder()
                .setId(product.getId())
                .setName(product.getProductName())
                .setAmount(product.getAmount())
                .build();
    }
}
