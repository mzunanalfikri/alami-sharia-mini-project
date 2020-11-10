package com.alami.miniproject.model;


import javax.persistence.*;

@Entity(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "seller_id")
    private Long sellerId;
    @Column(name = "nama")
    private String name;
    @Column(name = "satuan")
    private Long amount;
    @Column(name = "harga_satuan")
    private Long price;

    public Product(){

    }

    public Product(Long id, Long sellerId, String name, Long amount, Long price) {
        this.id = id;
        this.sellerId = sellerId;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
