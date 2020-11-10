package com.alami.miniproject.service;

import com.alami.miniproject.model.Product;
import com.alami.miniproject.model.Seller;
import com.alami.miniproject.payload.AddProduct;
import com.alami.miniproject.repository.ProductRepository;
import com.alami.miniproject.repository.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private SellerRepository sellerRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProducts() {
        // stub preparation
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(
                new Product(1L, 3L, "minum", 30L, 5000L),
                new Product(2L, 1L, "makan", 200L, 15000L),
                new Product(3L, 6L, "softdrink", 100L, 9000L),
                new Product(4L, 3L, "camilan", 9L, 4000L)
        ));
        assertEquals(4, productService.getAllProducts().size());
    }

    @Test
    void getProductBySellerId() {
        Long id = 4L;
        Mockito.when(productRepository.findBySellerId(id)).thenReturn(Arrays.asList(
                new Product(1L, 4L, "HP", 30L, 1000000L),
                new Product(2L, 4L, "Charger", 25L, 150000L)
        ));
        assertEquals(2, productService.getProductBySellerId(id).size());
    }

    @Test
    void addProductSuccess() {
        Long id = 2L;
        AddProduct newProduct = new AddProduct(id, "Produk Baru", 40L, 20000L);
        Mockito.when(sellerRepository.findById(id)).thenReturn(Optional.of(new Seller(id, "Ahmad", "Semarang")));
        assertEquals("Add Success.", productService.addProduct(newProduct));
    }

    @Test
    void addProductFail() {
        Long id = 2L;
        AddProduct newProduct = new AddProduct(id, "Produk Baru", 40L, 20000L);
        Mockito.when(sellerRepository.findById(id)).thenReturn(Optional.empty());
        assertEquals("Seller id not found.", productService.addProduct(newProduct));
    }

    @Test
    void searchProductByKeyword() {
        String key = "HP";
        Mockito.when(productRepository.findByNameContainingIgnoreCase(key)).thenReturn(Arrays.asList(
                new Product(1L, 4L, "HP", 30L, 1000000L),
                new Product(2L, 4L, "ChargerHP", 25L, 150000L)
        ));
        assertEquals(2, productService.searchProductByKeyword(key).size());
    }
}