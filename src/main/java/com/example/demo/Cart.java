package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> productList = new ArrayList<>();

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public void add(String item){
        productList.add(item);
    }
}
