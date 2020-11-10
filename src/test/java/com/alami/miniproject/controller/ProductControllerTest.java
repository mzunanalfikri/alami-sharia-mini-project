package com.alami.miniproject.controller;

import com.alami.miniproject.model.Product;
import com.alami.miniproject.payload.AddProduct;
import com.alami.miniproject.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    // mock for spring mvc
    @Autowired
    private MockMvc mockMvc;

    // mock product service
    @MockBean
    private ProductService productService;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAllProducts() throws Exception {
        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(
                new Product(1L, 1L, "penghapus", 20L, 10000L)
        ));
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{}]"));
    }

    @Test
    void listProductBySellerId() throws Exception {
        Long id = 1L;
        Mockito.when(productService.getProductBySellerId(id)).thenReturn(Arrays.asList(
                new Product(1L, id, "penghapus", 20L, 10000L),
                new Product(2L, id, "pensil", 50L, 20000L)

        ));
        mockMvc.perform(MockMvcRequestBuilders.get("/products-by-seller-id/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{}, {}]"));
    }

    @Test
    void searchProductByKeyword() throws Exception {
        String key = "HP";
        Mockito.when(productService.searchProductByKeyword(key)).thenReturn(Arrays.asList(
                new Product(1L, 2L, "HP", 20L, 1000000L),
                new Product(2L, 2L, "Charge HP", 50L, 200000L)

        ));
        mockMvc.perform(MockMvcRequestBuilders.get("/search?key=" + key))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{}, {}]"));
    }

    @Test
    void addProduct() throws Exception {
        Mockito.when(productService.addProduct(new AddProduct())).thenReturn("Status");
        AddProduct product = new AddProduct(1L, "Gunting", 3L,9000L);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/add-product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(product))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}