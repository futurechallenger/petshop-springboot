package com.petshop.orderservice.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class SQSConfigLocal {

    @Value("${order.queue.url}")
    private String orderQueueUrl;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    @Primary
    public AmazonSQSAsync sqsAsync() {
        return AmazonSQSAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(orderQueueUrl, region))
                .build();
    }
}
