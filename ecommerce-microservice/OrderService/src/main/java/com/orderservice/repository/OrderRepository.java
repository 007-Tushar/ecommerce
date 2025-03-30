package com.orderservice.repository;

import com.orderservice.dto.OrderDto;
import com.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<OrderDto> findAllByUserId(Long userId);

}
