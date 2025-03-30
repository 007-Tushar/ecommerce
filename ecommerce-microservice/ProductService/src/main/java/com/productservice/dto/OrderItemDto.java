package com.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long productId;

    private double price;

    private Long stock;

    public OrderItemDto(Long productId, Long stock) {
        this.productId = productId;
        this.stock = stock;
    }
}
