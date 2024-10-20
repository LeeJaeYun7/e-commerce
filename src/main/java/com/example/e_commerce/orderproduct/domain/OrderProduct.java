package com.example.e_commerce.orderproduct.domain;

import com.example.e_commerce.global.entity.BaseTimeEntity;
import com.example.e_commerce.order.domain.Order;
import com.example.e_commerce.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order_product")
@NoArgsConstructor
public class OrderProduct extends BaseTimeEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private long quantity;

    private long amount;

    @Builder
    public OrderProduct(Order order, Product product, long quantity, long amount){
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public static OrderProduct of(Order order, Product product, long quantity, long amount){
        return OrderProduct.builder()
                           .order(order)
                           .product(product)
                           .quantity(quantity)
                           .amount(amount)
                           .build();
    }
}
