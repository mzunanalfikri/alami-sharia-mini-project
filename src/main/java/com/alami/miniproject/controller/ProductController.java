package com.alami.miniproject.controller;

import com.alami.miniproject.model.Product;
import com.alami.miniproject.payload.AddProduct;
import com.alami.miniproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products-by-seller-id/{id}")
    public ResponseEntity<?> listProductBySellerId(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductBySellerId(id));
    }

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@Validated @RequestBody AddProduct product){
        String msg = productService.addProduct(product);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProductByKeyword(@RequestParam String key){
        return ResponseEntity.ok(productService.searchProductByKeyword(key));
    }
}
