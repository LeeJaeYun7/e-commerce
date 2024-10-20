package com.example.e_commerce.order.controller;

import com.example.e_commerce.order.dto.OrderRequest;
import com.example.e_commerce.order.service.OrderFacade;
import com.example.e_commerce.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class OrderController {

    private final OrderFacade orderFacade;
    private final OrderService orderService;

    public OrderController(OrderFacade orderFacade, OrderService orderService){
        this.orderFacade = orderFacade;
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public void makeOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        UUID uuid = orderRequest.getUuid();
        Map<Long, Long> orderProducts = orderRequest.getOrderProducts();

        orderFacade.makeOrder(uuid, orderProducts);
    }
}
