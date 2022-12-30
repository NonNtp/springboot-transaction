package com.redcats.springboottransaction.service.impl;

import com.redcats.springboottransaction.entity.Order;
import com.redcats.springboottransaction.entity.Payment;
import com.redcats.springboottransaction.exception.PaymentException;
import com.redcats.springboottransaction.payload.OrderRequest;
import com.redcats.springboottransaction.payload.OrderResponse;
import com.redcats.springboottransaction.repository.OrderRepository;
import com.redcats.springboottransaction.repository.PaymentRepository;
import com.redcats.springboottransaction.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository ;
    private PaymentRepository paymentRepository ;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type not support") ;
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse() ;
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse ;
    }

}
