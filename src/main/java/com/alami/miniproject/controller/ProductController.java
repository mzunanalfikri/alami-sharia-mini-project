package com.alami.miniproject.controller;

import com.alami.miniproject.model.Product;
import com.alami.miniproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String root(){
        return "Alami Sharia";
    }

    @GetMapping("/products")
    public ResponseEntity<?> listAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
