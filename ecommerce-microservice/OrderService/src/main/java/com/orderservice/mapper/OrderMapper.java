package com.orderservice.mapper;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderItemDto;
import com.orderservice.dto.OrderItemRequest;
import com.orderservice.dto.OrderRequest;
import com.orderservice.entity.Order;
import com.orderservice.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDto toDto(Order order){
        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getTotalPrice(),
                order.getProductDtos()
        );
    }

    public Order toEntity(OrderRequest orderRequest){
        return null;
    }

    public OrderItemDto toOrderItemDto(OrderItemRequest orderItemRequest){
        return new OrderItemDto(
                orderItemRequest.getProductId(),
                orderItemRequest.getQuantity()
        );
    }

    public OrderItem toOrderItem(OrderItemDto orderItemDto){
        return new OrderItem(
                orderItemDto.getProductId(),
                orderItemDto.getQuantity(),
                orderItemDto.getPrice()
        );
    }

}
