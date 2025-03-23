package com.orderservice.mapper;

import com.orderservice.dto.OrderDto;
import com.orderservice.entity.Order;

public class OrderMapper {
    public OrderDto toDto(Order order){
        return new OrderDto(
                order.getOrderId(),
                order.getProductId(),
                order.getUserId(),
                order.getQuantity(),
                order.getTotalPrice()
        );
    }

    public Order toEntity(OrderDto orderDto){
        return new Order(
                orderDto.getProductId(),
                orderDto.getUserId(),
                orderDto.getQuantity(),
                orderDto.getTotalPrice()
        );
    }
}
