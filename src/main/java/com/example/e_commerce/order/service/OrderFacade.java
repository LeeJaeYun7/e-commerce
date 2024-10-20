package com.example.e_commerce.order.service;

import com.example.e_commerce.member.domain.Member;
import com.example.e_commerce.member.service.MemberService;
import com.example.e_commerce.order.domain.Order;
import com.example.e_commerce.orderproduct.service.OrderProductService;
import com.example.e_commerce.payment.service.PaymentService;
import com.example.e_commerce.product.service.ProductService;
import com.example.e_commerce.stock.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
public class OrderFacade {

    private final MemberService memberService;
    private final OrderService orderService;

    private final StockService stockService;
    private final ProductService productService;

    private final OrderProductService orderProductService;
    private final PaymentService paymentService;

    public OrderFacade(MemberService memberService, OrderService orderService, StockService stockService, ProductService productService, OrderProductService orderProductService, PaymentService paymentService){
        this.memberService = memberService;
        this.orderService = orderService;
        this.stockService = stockService;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.paymentService = paymentService;
    }

    @Transactional
    public void makeOrder(UUID uuid, Map<Long, Long> orderProducts) throws Exception {
        Member member = memberService.getMemberByUuid(uuid);
        long totalOrderAmount = getTotalOrderAmount(orderProducts);
        member.isOrderAvailable(totalOrderAmount);

        stockService.checkStockExists(orderProducts);
        Order newOrder = orderService.makeOrder(uuid, totalOrderAmount);

        orderProductService.makeOrderProducts(newOrder, orderProducts);

        paymentService.makePayment(uuid, newOrder, totalOrderAmount);
        memberService.decreaseBalance(uuid, totalOrderAmount);
    }

    public long getTotalOrderAmount(Map<Long, Long> orderProducts) throws Exception {
        long totalOrderAmount = 0;

        for(Long productId: orderProducts.keySet()){
            long price = productService.getProductPrice(productId);
            long orderAmount = orderProducts.get(productId);
            totalOrderAmount += (price*orderAmount);
        }
        return totalOrderAmount;
    }
}
