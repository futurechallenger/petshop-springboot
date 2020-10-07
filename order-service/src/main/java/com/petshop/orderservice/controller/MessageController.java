package com.petshop.orderservice.controller;

import com.petshop.orderservice.dto.OrderDTO;
import com.petshop.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/sqs")
@RestController
public class MessageController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/create")
    public ResponseEntity<?> sendMessage(/*@RequestBody Map<String, String> req*/) {
        try {

            orderService.createOrder();
            return ResponseEntity.ok(0);
        } catch (Exception e) {
//            log.error("ERROR: creating order: {}", e.getMessage());
            OrderDTO ret = new OrderDTO();
//            ret.setMessage("Something is wrong");
            return ResponseEntity.status(500).body(ret);
        }
    }
}
