package com.petshop.orderservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
//@RequiredArgsConstructor(staticName = "of")
public class Order {
    // Internal member variables
    private int orderId;
    private long date;
    private String userId;
    private CreditCard creditCard;
    private Address billingAddress;
    private Address shippingAddress;
    private double orderTotal;
    private LineItem[] lineItems;
    private Optional<Integer> authorizationNumber;
}
