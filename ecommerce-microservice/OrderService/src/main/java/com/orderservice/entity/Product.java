package com.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    private Long productId;
    private String productName;
    private Double price;
    private Long stock;

    public Product(String productName, Double price, Long stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
}
