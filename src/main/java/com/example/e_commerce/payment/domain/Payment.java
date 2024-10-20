package com.example.e_commerce.payment.domain;

import com.example.e_commerce.global.entity.BaseTimeEntity;
import com.example.e_commerce.order.domain.Order;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "payment")
@NoArgsConstructor
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid;

    @OneToOne
    private Order order;

    private long amount;

    @Builder
    public Payment(UUID uuid, Order order, long amount){
        this.uuid = uuid;
        this.order = order;
        this.amount = amount;
    }

    public static Payment of(UUID uuid, Order order, long amount){
        return Payment.builder()
                      .uuid(uuid)
                      .order(order)
                      .amount(amount)
                      .build();
    }
}
