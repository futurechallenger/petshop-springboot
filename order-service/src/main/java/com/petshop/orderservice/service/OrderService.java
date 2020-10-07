package com.petshop.orderservice.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.petshop.orderservice.config.SQSConfig;
import com.petshop.orderservice.model.Order;
//import lombok.Data;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
//import java.util.Queue;

//@Slf4j
@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    //    @Autowired
//    SQSConfig sqsConfig;
    @Value("${order.queue.url}")
    private String orderQueueUrl;

    @Value("${order.queue.name}")
    private String queueName;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    private AmazonSQSAsync sqsAsync;

    public void createOrder() {
        try {
//            Order order = Order.of();
            Order order = new Order();
            String orderJson = new ObjectMapper().writeValueAsString(order);
            /**
             *     public static AmazonSQS defaultClient() {
             *         return standard().build();
             *     }
             */
//            final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
//            sqsAsync.sendMessage(new SendMessageRequest(orderQueueUrl, orderJson));//.withMessageGroupId(""));

            queueMessagingTemplate.convertAndSend(queueName, orderJson);
        } catch (Exception e) {
            log.error("Error creating order, message: {}", e.getMessage());
        }
    }

    @SqsListener("${order.queue.name}")
    public void processOrder(String json) throws IOException {
        Order order = new ObjectMapper().readValue(json, Order.class);
        log.info("==>Received order json {}", json);
    }
}
