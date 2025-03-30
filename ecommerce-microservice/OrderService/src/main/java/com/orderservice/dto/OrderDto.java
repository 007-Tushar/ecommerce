package com.orderservice.dto;

import com.orderservice.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    private Double totalPrice;

    private List<Product> products;

    public OrderDto(Long productId, Long userId, Double totalPrice, List<Product> products) {
        this.productId = productId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.products = products;
    }

}
