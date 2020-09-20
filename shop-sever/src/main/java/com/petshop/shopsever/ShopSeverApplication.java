package com.petshop.shopsever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShopSeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSeverApplication.class, args);
    }

}
