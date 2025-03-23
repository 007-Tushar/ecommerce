package com.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    private int quantity;

    private Double totalPrice;

    public Order(Long productId, Long userId, int quantity, Double totalPrice) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
