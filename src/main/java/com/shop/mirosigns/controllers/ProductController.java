package com.shop.mirosigns.controllers;

import com.shop.mirosigns.model.Product;

import com.shop.mirosigns.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public String productList(Model model) {
        // get products from db
        List<Product> theProducts = productService.findAll();

        // add to the spring model
        model.addAttribute("products", theProducts);
        return "products_list";
    }

    @GetMapping("/")
    public String productList2(Model model) {
        // get products from db
        List<Product> theProducts = productService.findAll();

        // add to the spring model
        model.addAttribute("products", theProducts);
        return "index";
    }

    @GetMapping("/list/{productId}")
    public String getProductDetailns(Model model, @PathVariable String productId) {
        int id = Integer.parseInt(productId);
        List<Product> collect = productService.findAll();
        List<Product> collect1 = collect.stream().filter(product -> product.getId() == id).collect(Collectors.toList());
        for (Product product : collect1) {
            model.addAttribute("zmienna",product);
        }
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }


}
