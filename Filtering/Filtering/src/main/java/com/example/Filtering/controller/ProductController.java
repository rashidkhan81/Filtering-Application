package com.example.Filtering.controller;

import com.example.Filtering.entity.Product;
import com.example.Filtering.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String viewProducts(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        if (keyword != null) {
            model.addAttribute("products", productService.searchProductsByName(keyword));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        return "products";
    }

    // Modified method to save a list of products
    @PostMapping("/products")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> savedProducts = productService.saveAllProducts(products);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }
}
