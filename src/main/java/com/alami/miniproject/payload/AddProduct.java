package com.alami.miniproject.payload;

public class AddProduct {
    private Long seller_id;
    private String name;
    private Long amount;
    private Long price;

    public AddProduct(){}

    public AddProduct(Long seller_id, String name, Long amount, Long price) {
        this.seller_id = seller_id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
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
