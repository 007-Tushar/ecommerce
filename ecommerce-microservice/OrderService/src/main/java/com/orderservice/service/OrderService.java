package com.orderservice.service;

import com.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto getOrderById(Long orderId);

    List<OrderDto> getAllOrderByUserId(Long userId);

    List<OrderDto> getAllOrderByProductId(Long productId);
}
