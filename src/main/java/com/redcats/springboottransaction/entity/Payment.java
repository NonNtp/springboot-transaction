package com.redcats.springboottransaction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String type ;

    private String cardName ;

    private String cardNumber ;

    private Integer expiryYear ;

    private  Integer expiryMonth ;

    private Integer cvc ;

    private Long orderId ;
}
