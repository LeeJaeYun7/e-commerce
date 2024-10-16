package com.example.e_commerce.product.service;

import com.example.e_commerce.product.domain.Product;
import com.example.e_commerce.product.dto.ProductResponse;
import com.example.e_commerce.stock.domain.Stock;
import com.example.e_commerce.stock.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class ProductFacadeService {

    private final ProductService productService;
    private final StockService stockService;

    public ProductFacadeService(ProductService productService, StockService stockService){
        this.productService = productService;
        this.stockService = stockService;
    }

    public ProductResponse searchProduct(long productId) throws Exception {
        Product product = productService.getProduct(productId);
        Stock stock = stockService.getStock(productId);

        return ProductResponse.of(product, stock);
    }
}
