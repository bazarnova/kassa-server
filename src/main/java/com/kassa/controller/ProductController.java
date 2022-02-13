package com.kassa.controller;

import com.kassa.entity.Product;
import com.kassa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/products")
    @ResponseBody
    public List<Product> productList() {
        List<Product> list = productService.getAllProducts();
        return list;
    }

    @PostMapping(value = "/products",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {

        return productService.addNewProduct(product);

    }

}
