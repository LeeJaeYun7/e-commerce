package com.example.e_commerce.product.controller;

import com.example.e_commerce.product.dto.ProductResponse;
import com.example.e_commerce.product.dto.ProductStockResponse;
import com.example.e_commerce.product.service.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade){
        this.productFacade = productFacade;
    }

    @GetMapping("/product/search")
    public ResponseEntity<ProductStockResponse> searchProduct(@RequestParam long productId) throws Exception {
        ProductStockResponse productStockResponse = productFacade.searchProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body(productStockResponse);
    }
}
