package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;
import com.kassa.mybatis.ProductMapper;
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
        ProductDTO productDTO = new ProductDTO.Builder()
                .setId(product.getId())
                .setName(product.getName())
                .setAmount(product.getAmount())
                .setAccount(product.getAccount())
                .setWeight(product.getWeight())
                .setCheck_id(product.getCheck_id())
                .setDescription(product.getComment())
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
            Product product = new Product.Builder()
                    .setId(productDTO.getId())
                    .setName(productDTO.getProductName())
                    .setAmount(productDTO.getAmount())
                    .setAccount(productDTO.getAmount())
                    .setWeight(productDTO.getWeight())
                    .setCheck_id(productDTO.getCheckId())
                    .setComment(productDTO.getDescription())
                    .build();
            products.add(product);
        }
        return products;
    }
}
