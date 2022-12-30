package com.redcats.springboottransaction.service;

import com.redcats.springboottransaction.payload.OrderRequest;
import com.redcats.springboottransaction.payload.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest) ;
}
