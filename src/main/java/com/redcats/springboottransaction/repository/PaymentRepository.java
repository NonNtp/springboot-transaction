package com.redcats.springboottransaction.repository;

import com.redcats.springboottransaction.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Long> {
}
