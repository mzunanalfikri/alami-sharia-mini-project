package com.alami.miniproject.service;

import com.alami.miniproject.model.Product;
import com.alami.miniproject.model.Seller;
import com.alami.miniproject.payload.AddProduct;
import com.alami.miniproject.repository.ProductRepository;
import com.alami.miniproject.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductBySellerId(Long sellerId){
        return productRepository.findBySellerId(sellerId);
    }

    public String addProduct(AddProduct product){
        Optional<Seller> sellerOptional = sellerRepository.findById(product.getSeller_id());
        // check seller in database or not
        if (sellerOptional.isPresent()){
            Product new_product = new Product();
            new_product.setSellerId(product.getSeller_id());
            new_product.setName(product.getName());
            new_product.setAmount(product.getAmount());
            new_product.setPrice(product.getPrice());
            productRepository.save(new_product);
            return "Add Success.";
        } else {
            return "Seller id not found.";
        }
    }

    public List<Product> searchProductByKeyword(String key){
        return productRepository.findByNameContainingIgnoreCase(key);
    }
}
