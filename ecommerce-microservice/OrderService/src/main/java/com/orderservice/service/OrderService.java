package com.orderservice.service;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderRequest;

import java.util.List;

public interface OrderService {

    OrderDto getOrderById(Long orderId);

    OrderDto createOrder(OrderRequest orderRequest);

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrderByUserId(Long userId);

    List<OrderDto> getAllOrderByProductId(Long productId);
}
