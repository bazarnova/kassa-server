package com.kassa.repository;

import com.kassa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    List<Product> findAll();

    List<Product> findProductByProductName(String productName);

    List<Product> getProductByCheck_Id(Long checkId);

    Product getProductById(Long id);

    int deleteProductById(Long id);
}
