package com.example.e_commerce.stock.domain;

import com.example.e_commerce.global.entity.BaseTimeEntity;
import com.example.e_commerce.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "stock")
public class Stock extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private long quantity;
}
