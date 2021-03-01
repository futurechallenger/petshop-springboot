package com.petshop.shopsever.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
public class OrderController {

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderInfo order) {
        return ResponseEntity.status(200).body(null);
    }
}
