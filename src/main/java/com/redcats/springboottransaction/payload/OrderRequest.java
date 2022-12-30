package com.redcats.springboottransaction.payload;

import com.redcats.springboottransaction.entity.Order;
import com.redcats.springboottransaction.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Order order ;
    private Payment payment ;
}
