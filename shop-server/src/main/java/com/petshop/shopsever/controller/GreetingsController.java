package com.petshop.shopsever.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.Collections;

@RequestMapping("/greetings")
@RestController
public class GreetingsController {

    @GetMapping("/{name}")
    public ResponseEntity<?> greetings(@PathVariable String name) {
        return ResponseEntity.ok(Collections.singletonMap("data", String.format("Hello %s", name)));
    }
}
