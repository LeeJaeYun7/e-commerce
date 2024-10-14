package com.example.e_commerce.stock.service;

import com.example.e_commerce.stock.domain.Stock;
import com.example.e_commerce.stock.repository.StockRepository;

public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Stock getStock(long productId) throws Exception {
        return stockRepository.findByIdWithLock(productId).orElseThrow(() -> new Exception());
    }
}
