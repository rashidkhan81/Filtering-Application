package com.example.Filtering.service;

import com.example.Filtering.entity.Product;
import com.example.Filtering.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    public List<Product> searchProductsByName(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    // Modified method to save a list of products
    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}
