package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;
import com.kassa.flyway.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product addNewProduct(Product product) {
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .amount(product.getAmount())
                .account(product.getAccount())
                .weight(product.getWeight())
                .checkId(product.getCheckId())
                .description(product.getComment())
                .build();

        productMapper.addProduct(productDTO);
        product.setId(productDTO.getId());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();
        List<ProductDTO> productDTOS = productMapper.getAllProducts();
        for (ProductDTO productDTO : productDTOS) {
            Product product = Product.builder()
                    .id(productDTO.getId())
                    .productName(productDTO.getProductName())
                    .amount(productDTO.getAmount())
                    .account(productDTO.getAmount())
                    .weight(productDTO.getWeight())
                    .checkId(productDTO.getCheckId())
                    .comment(productDTO.getDescription())
                    .build();
            products.add(product);
        }
        return products;
    }
    @Override
    public List<Product> getProductsByName(String productName) {

        List<Product> products = new ArrayList<>();
        List<ProductDTO> productDTOS = productMapper.getProductsByName(productName);
        for (ProductDTO productDTO : productDTOS) {
            Product product = Product.builder()
                    .id(productDTO.getId())
                    .productName(productDTO.getProductName())
                    .amount(productDTO.getAmount())
                    .account(productDTO.getAmount())
                    .weight(productDTO.getWeight())
                    .checkId(productDTO.getCheckId())
                    .comment(productDTO.getDescription())
                    .build();
            products.add(product);
        }
        return products;
    }

    public List<Product> getProductsByCheckId(Long checkId){
        List<Product> products = new ArrayList<>();
        List<ProductDTO> productDTOS = productMapper.getProductsByCheckId(checkId);
        for (ProductDTO productDTO : productDTOS) {
            Product product = Product.builder()
                    .id(productDTO.getId())
                    .productName(productDTO.getProductName())
                    .amount(productDTO.getAmount())
                    .account(productDTO.getAmount())
                    .weight(productDTO.getWeight())
                    .checkId(productDTO.getCheckId())
                    .comment(productDTO.getDescription())
                    .build();
            products.add(product);
        }
        return products;
    }
    public Product getProductById(Long id) {
        ProductDTO productDTO = productMapper.getProductById(id);
        return Product.builder()
                .id(productDTO.getId())
                .productName(productDTO.getProductName())
                .amount(productDTO.getAmount())
                .account(productDTO.getAmount())
                .weight(productDTO.getWeight())
                .checkId(productDTO.getCheckId())
                .comment(productDTO.getDescription())
                .build();
    }
    public boolean deleteProduct(Long id){
        int number = productMapper.deleteProduct(id);
        return number > 0;
    }
}
