package com.example.e_commerce.product.service;

import com.example.e_commerce.product.domain.Product;
import com.example.e_commerce.product.dto.ProductStockResponse;
import com.example.e_commerce.stock.domain.Stock;
import com.example.e_commerce.stock.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductFacade {

    private final ProductService productService;
    private final StockService stockService;

    public ProductFacade(ProductService productService, StockService stockService){
        this.productService = productService;
        this.stockService = stockService;
    }

    @Transactional
    public ProductStockResponse searchProduct(long productId) throws Exception {
        Product product = productService.getProduct(productId);
        Stock stock = stockService.getStock(productId);

        return ProductStockResponse.of(product, stock);
    }
}
