package com.example.e_commerce.order.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "order")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid;

    @Column(name = "total_amount")
    private long totalAmount;

    @Builder
    public Order(UUID uuid, long totalAmount){
        this.uuid = uuid;
        this.totalAmount = totalAmount;
    }

    public static Order of(UUID uuid, long totalAmount){
        return Order.builder()
                    .uuid(uuid)
                    .totalAmount(totalAmount)
                    .build();
    }

}
