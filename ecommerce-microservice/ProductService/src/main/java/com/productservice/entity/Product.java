package com.productservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    private Double price;
    private Long stock;

    public Product(String productName, Double price, Long stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
}
