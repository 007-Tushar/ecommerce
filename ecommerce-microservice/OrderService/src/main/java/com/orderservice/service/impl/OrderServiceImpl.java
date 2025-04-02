package com.orderservice.service.impl;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderItemDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.ProductDto;
import com.orderservice.entity.Order;
import com.orderservice.entity.OrderItem;
import com.orderservice.mapper.OrderMapper;
import com.orderservice.repository.OrderItemRepository;
import com.orderservice.repository.OrderRepository;
import com.orderservice.service.OrderService;
import com.orderservice.service.ProductClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderMapper orderMapper, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderMapper = orderMapper;
        this.productClient = productClient;
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order with ID " + orderId + " not found."));
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(item -> {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setOrderId(item.getOrderId());
                    orderDto.setUserId(item.getUserId());
                    orderDto.setTotalPrice(item.getTotalPrice());
                    return orderDto;
                })
                .toList();
    }


    @Override
    public List<OrderDto> getAllOrderByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }


    public OrderDto createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());

        Order savedOrder = orderRepository.save(order);

        // Call Feign Client to create order items
        List<OrderItemDto> orderItemDtos = orderRequest.getOrderItemRequests().stream()
                .map(productClient::createOrderItem) // Feign Client call
                .map(ResponseEntity::getBody)
                .toList();

        // Convert Dtos to Entities
        List<OrderItem> orderItems = orderItemDtos.stream()
                .map(orderItemDto -> {
                    OrderItem orderItem = orderMapper.toOrderItem(orderItemDto);
                    return orderItem;
                })
                .collect(Collectors.toList());

        // Extract Product Dtos using product id
        List<ProductDto> productDtos = orderItemDtos.stream()
                .map(orderItemDto -> productClient.getProduct(orderItemDto.getProductId()))
                .map(ResponseEntity::getBody)
                .toList();

        // Saving OrderItems
        orderItemRepository.saveAll(orderItems);

        // Calculate total price
        double totalPrice = orderItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        // Update savedOrder with orderItems & total price
        savedOrder.setOrderItems(orderItems);
        savedOrder.setTotalPrice(totalPrice);
        orderRepository.save(savedOrder);

        // Return OrderDto
        return new OrderDto(
                savedOrder.getOrderId(),
                savedOrder.getUserId(),
                totalPrice,
                productDtos
        );
    }


}

