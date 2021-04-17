package com.shop.mirosigns.controllers;

import com.shop.mirosigns.model.Product;
import com.shop.mirosigns.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public String listProducts(Model model) {

        // get products from db
        List<Product> theProducts = productService.findAll();

        // add to the spring model
        model.addAttribute("products", theProducts);

        return "products/list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind form data
        Product theProducts = new Product();

        model.addAttribute("products", theProducts);
        // send to form
        return "products/product-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId,
                                    Model model) {

        // get the product from the service
        Product theProducts = productService.findById(theId);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("products", theProducts);

        // send over to our form
        return "products/product-form";
    }

    //
//
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product theProduct) {

        // save the product
        productService.save(theProduct);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int theId) {

        // delete the product
        productService.deleteById(theId);

        // redirect to /products/list
        return "redirect:/products/list";

    }

}
