package com.petshop.orderservice.model;

import lombok.Data;

@Data
public class Address {
    // Internal member variables
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String email;
}
