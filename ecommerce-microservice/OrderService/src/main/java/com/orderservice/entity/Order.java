package com.orderservice.entity;

import com.orderservice.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "orderId")
    private List<OrderItem> orderItems;

    @ManyToMany
    @Transient
    private List<ProductDto> productDtos;

    public Order(Long userId, Double totalPrice, List<OrderItem> orderItems, List<ProductDto> productDtos) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
        this.productDtos = productDtos;
    }
}
