package com.petshop.shopsever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShopSeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSeverApplication.class, args);
    }

}
