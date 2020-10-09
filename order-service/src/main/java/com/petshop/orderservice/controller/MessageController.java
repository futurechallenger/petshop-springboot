package com.petshop.orderservice.controller;

import com.petshop.orderservice.dto.OrderDTO;
import com.petshop.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/sqs")
@RestController
public class MessageController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/create/{count}", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage(@PathVariable(name = "count") long itemCount) {
        try {
            orderService.createOrder(itemCount);
            return ResponseEntity.ok(0);
        } catch (Exception e) {
//            log.error("ERROR: creating order: {}", e.getMessage());
            OrderDTO ret = new OrderDTO();
//            ret.setMessage("Something is wrong");
            return ResponseEntity.status(500).body(ret);
        }
    }
}
