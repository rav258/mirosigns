package com.shop.mirosigns.controllers;

import com.shop.mirosigns.model.Product;

import com.shop.mirosigns.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public String productList(Model model){
        // get products from db
        List<Product> theProducts = productService.findAll();

        // add to the spring model
        model.addAttribute("products", theProducts);
        return "products_list";
    }


}
