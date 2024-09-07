package com.example.mq.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.rabbitmq")
@Getter
@RequiredArgsConstructor
public class RabbitMqProperties {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String queueName;
    private final String exchangeName;
    private final String routingKey;
}
