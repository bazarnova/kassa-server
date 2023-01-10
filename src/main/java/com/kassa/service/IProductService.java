package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;

import java.util.List;

public interface IProductService {
    ProductDTO addNewProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByName(String productName);
    List<ProductDTO> getProductsByCheckId(Long checkId);
    ProductDTO getProductById(Long id);
    boolean deleteProduct (Long id);
}
