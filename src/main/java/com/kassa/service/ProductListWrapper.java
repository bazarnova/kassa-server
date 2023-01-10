package com.kassa.service;

import com.kassa.dto.ProductDTO;
import com.kassa.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListWrapper {

    private List<ProductDTO> productList;

    public ProductListWrapper(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public ProductListWrapper( ) {
        productList = new ArrayList<>();
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
