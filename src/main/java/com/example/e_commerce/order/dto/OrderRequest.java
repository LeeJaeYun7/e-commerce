package com.example.e_commerce.order.dto;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class OrderRequest {

    private final UUID uuid;
    private final Map<Long, Long> orderProducts;

    public OrderRequest(UUID uuid, Map<Long, Long> orderProducts){
        this.uuid = uuid;
        this.orderProducts = orderProducts;
    }
}
