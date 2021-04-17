package com.shop.mirosigns.controllers;

import com.shop.mirosigns.model.Product;
import com.shop.mirosigns.service.Cart;
import com.shop.mirosigns.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String getCartItems(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable int productId) {
        Product product = productService.findById(productId);
        cart.addToCart(product);
        return "redirect:/list/";
    }
    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable int productId) {
        Product product = productService.findById(productId);
        cart.removeFromCart(product);
        return "redirect:/cart/";
    }

    @PostMapping("/recalculate")
    public String addToCart(Cart updatedCart) {
        return "redirect:/cart";
    }



}
