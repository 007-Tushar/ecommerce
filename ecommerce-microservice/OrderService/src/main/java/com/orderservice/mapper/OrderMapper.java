package com.orderservice.mapper;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDto toDto(Order order){
        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getTotalPrice(),
                order.getProducts()
        );
    }

    public Order toEntity(OrderRequest orderRequest){
        return null;
    }
}
