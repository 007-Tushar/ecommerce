package com.orderservice.service.impl;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.entity.Order;
import com.orderservice.mapper.OrderMapper;
import com.orderservice.repository.OrderRepository;
import com.orderservice.service.OrderService;
import com.orderservice.service.ProductClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order with ID " + orderId + " not found."));
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.toEntity(orderRequest);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(orderMapper::toDto)
                .toList();
    }


    @Override
    public List<OrderDto> getAllOrderByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public List<OrderDto> getAllOrderByProductId(Long productId) {
        return List.of();
    }

}
