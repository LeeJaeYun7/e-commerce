package com.example.e_commerce.orderproduct.service;

import com.example.e_commerce.order.domain.Order;
import com.example.e_commerce.orderproduct.domain.OrderProduct;
import com.example.e_commerce.orderproduct.dto.Top5ProductOrdersIn3DaysResponse;
import com.example.e_commerce.orderproduct.repository.OrderProductRepository;
import com.example.e_commerce.product.domain.Product;
import com.example.e_commerce.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;

    public OrderProductService(OrderProductRepository orderProductRepository, ProductService productService){
        this.orderProductRepository = orderProductRepository;
        this.productService = productService;
    }

    public void makeOrderProducts(Order order, Map<Long,Long> orderProducts) throws Exception {

        for(long productId: orderProducts.keySet()){

            Product product = productService.getProduct(productId);
            long orderQuantity = orderProducts.get(productId);
            long orderAmount = product.getPrice()*orderQuantity;

            OrderProduct orderProduct = OrderProduct.of(order, product, orderQuantity, orderAmount);
            orderProductRepository.save(orderProduct);
        }
    }

    public Top5ProductOrdersIn3DaysResponse getTop5ProductOrdersIn3Days(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threshold = now.minusDays(3);

        List<OrderProduct> orderProductList = orderProductRepository.findAllIn3Days(threshold);
        Map<Long, Long> productSalesIn3Days = new HashMap<>();

        for(OrderProduct orderProduct: orderProductList){
             long productId = orderProduct.getProduct().getId();
             long quantity = orderProduct.getQuantity();

             productSalesIn3Days.merge(productId, quantity, Long::sum);
        }

        List<Map.Entry<Long, Long>> sortedEntries = new ArrayList<>(productSalesIn3Days.entrySet());
        sortedEntries.sort(Map.Entry.<Long, Long>comparingByValue().reversed());

        List<Map.Entry<Long, Long>> top5Entries = sortedEntries.stream().limit(5).toList();

        return Top5ProductOrdersIn3DaysResponse.of(top5Entries);
    }
}
