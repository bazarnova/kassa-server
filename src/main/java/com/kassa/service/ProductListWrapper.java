package com.kassa.service;

import com.kassa.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListWrapper {

    private List<Product> productList;

    public ProductListWrapper(List<Product> productList) {
        this.productList = productList;
    }

    public ProductListWrapper( ) {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
