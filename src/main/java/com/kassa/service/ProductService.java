package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;
import com.kassa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO addNewProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .id(productDTO.getId())
                .productName(productDTO.getProductName())
                .amount(productDTO.getAmount())
                .account(productDTO.getAccount())
                .weight(productDTO.getWeight())
                .checkId(productDTO.getCheckId())
                .comment(productDTO.getComment())
                .build();

        productRepository.save(product);
        productDTO.setId(product.getId());
        return productDTO;
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .amount(product.getAmount())
                    .account(product.getAmount())
                    .weight(product.getWeight())
                    .checkId(product.getCheckId())
                    .comment(product.getComment())
                    .build();
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductsByName(String productName) {

        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.findProductByProductName(productName);
        for (Product product : products) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .amount(product.getAmount())
                    .account(product.getAmount())
                    .weight(product.getWeight())
                    .checkId(product.getCheckId())
                    .comment(product.getComment())
                    .build();
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    public List<ProductDTO> getProductsByCheckId(Long checkId) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.getProductByCheck_Id(checkId);
        for (Product product : products) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .amount(product.getAmount())
                    .account(product.getAmount())
                    .weight(product.getWeight())
                    .checkId(product.getCheckId())
                    .comment(product.getComment())
                    .build();
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.getProductById(id);
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .amount(product.getAmount())
                .account(product.getAmount())
                .weight(product.getWeight())
                .checkId(product.getCheckId())
                .comment(product.getComment())
                .build();
    }

    public boolean deleteProduct(Long id) {
        int number = productRepository.deleteProductById(id);
        return number > 0;
    }
}
