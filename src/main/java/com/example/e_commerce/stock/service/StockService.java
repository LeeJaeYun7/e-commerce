package com.example.e_commerce.stock.service;

import com.example.e_commerce.stock.domain.Stock;
import com.example.e_commerce.stock.repository.StockRepository;

import java.util.Map;

public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Stock getStock(long productId) throws Exception {
        return stockRepository.findByIdWithLock(productId).orElseThrow(Exception::new);
    }

    public void checkStockExists(Map<Long, Long> orderProducts) throws Exception {
        for(long productId: orderProducts.keySet()){
            long productQuantity = getStock(productId).getQuantity();
            long orderQuantity = orderProducts.get(productId);
            if(productQuantity < orderQuantity){
                throw new Exception();
            }
        }
    }
}
