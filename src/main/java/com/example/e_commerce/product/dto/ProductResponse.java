package com.example.e_commerce.product.dto;

import com.example.e_commerce.product.domain.Product;
import com.example.e_commerce.stock.domain.Stock;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

    private final String name;
    private final long price;
    private final long quantity;

    @Builder
    public ProductResponse(String name, long price, long quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ProductResponse of(Product product, Stock stock){
        return ProductResponse.builder()
                              .name(product.getName())
                              .price(product.getPrice())
                              .quantity(stock.getQuantity())
                              .build();
    }
}
