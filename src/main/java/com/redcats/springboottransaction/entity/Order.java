package com.redcats.springboottransaction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String orderTrackingNumber ;

    private Integer totalQuantity ;

    private BigDecimal totalPrice ;

    private String status ;

    @CreationTimestamp
    private LocalDateTime dateCreated ;

    @UpdateTimestamp
    private LocalDateTime lastUpdated ;

    private Long shoppingCartId ;

}