package com.petshop.orderservice.model;

import lombok.Data;

@Data
public class CreditCard {
    private String cardType;
    private String cardNumber;
    private String cardExpiration;
}
