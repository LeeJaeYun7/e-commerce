package com.example.e_commerce.product.controller;

import com.example.e_commerce.product.dto.ProductResponse;
import com.example.e_commerce.product.service.ProductFacadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductFacadeService productFacadeService;

    public ProductController(ProductFacadeService productFacadeService){
        this.productFacadeService = productFacadeService;
    }

    @GetMapping("/product/search")
    public ResponseEntity<ProductResponse> searchProduct(@RequestParam long productId) throws Exception {
        ProductResponse productResponse = productFacadeService.searchProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
}
