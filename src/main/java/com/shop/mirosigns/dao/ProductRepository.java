package com.shop.mirosigns.dao;

import com.shop.mirosigns.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
