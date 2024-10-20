package com.example.e_commerce.orderproduct.controller;

import com.example.e_commerce.orderproduct.dto.Top5ProductOrdersIn3DaysResponse;
import com.example.e_commerce.orderproduct.service.OrderProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProductController {

    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService){
        this.orderProductService = orderProductService;
    }

    @GetMapping("/orderProduct/search/top5/in3Days")
    public ResponseEntity<Top5ProductOrdersIn3DaysResponse> getTop5ProductOrdersIn3Days(){
        Top5ProductOrdersIn3DaysResponse top5ProductOrdersIn3DaysResponse = orderProductService.getTop5ProductOrdersIn3Days();
        return ResponseEntity.status(HttpStatus.OK).body(top5ProductOrdersIn3DaysResponse);
    }
}
