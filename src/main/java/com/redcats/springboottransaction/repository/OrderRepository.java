package com.redcats.springboottransaction.repository;

import com.redcats.springboottransaction.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {
}
