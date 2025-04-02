package com.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long productId;
    private int quantity;
    private double price;

    public OrderItemDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}