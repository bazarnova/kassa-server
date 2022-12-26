package com.kassa.service;

import com.kassa.entity.Product;

import java.util.List;

public interface IProductService {
    Product addNewProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String productName);
    List<Product> getProductsByCheckId(Long checkId);
    Product getProductById(Long id);
    boolean deleteProduct (Long id);
}
