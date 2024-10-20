package com.example.e_commerce.payment.service;

import com.example.e_commerce.order.domain.Order;
import com.example.e_commerce.payment.domain.Payment;
import com.example.e_commerce.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public void makePayment(UUID uuid, Order order, long totalOrderAmount){
        Payment payment = Payment.of(uuid, order, totalOrderAmount);
        paymentRepository.save(payment);
    }
}
