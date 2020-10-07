package com.petshop.orderservice.model;

import lombok.Data;

@Data
public class LineItem {
    // Internal member variables
    private String id;
    private String productName;
    private int line;
    private int quantity;
    private double price;
}
