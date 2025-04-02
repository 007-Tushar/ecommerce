package com.orderservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    private Double totalPrice;

    private List<ProductDto> productDtos;

}
