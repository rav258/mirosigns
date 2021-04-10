package com.shop.mirosigns.service;

import com.shop.mirosigns.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(int theId);

    void save(Product theProduct);

    void deleteById(int theId);

}
