package com.petshop.orderservice.service;

import com.petshop.orderservice.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

//    @Value("${order.queue.name}")
//    private String queueName;
    final static String QUEUE_NAME = "order_queue";

    @SqsListener("${order.queue.name}")
//    @SqsListener(QUEUE_NAME)
    public void subscribeToSQSDirectly(String message, @Header("SenderId") String senderId) {
        log.error("Received message: " + message);
    }
}
