package com.kassa.controller;

import com.kassa.entity.Product;
import com.kassa.service.IProductService;
import com.kassa.service.ProductListWrapper;
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
        return productService.getAllProducts();
    }

    @GetMapping(value = "/products/name/{name}")
    @ResponseBody
    public ProductListWrapper getProductsByName(@PathVariable String name) {
        return new ProductListWrapper(productService.getProductsByName(name));
    }

    @PostMapping(value = "/product",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @GetMapping(value = "/products/id/{checkId}")
    @ResponseBody
    public List<Product> getProductsByName(@PathVariable("checkId") Long checkId) {
        return productService.getProductsByCheckId(checkId);
    }
    @GetMapping(value = "/product/id/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
    @DeleteMapping(value = "/product/id/{id}")
    @ResponseBody
    public boolean deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
