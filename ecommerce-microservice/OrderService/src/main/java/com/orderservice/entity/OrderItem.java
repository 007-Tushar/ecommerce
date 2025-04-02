package com.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderItemId;
//    @OneToOne(mappedBy = "order_item")
//    private Order order;
    @Column(name = "product_id")
    private Long productId;
    private int quantity;
    private Double price;

    public OrderItem(Long productId, int quantity, Double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
