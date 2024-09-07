package com.example.mq.service;


import com.example.mq.dto.MessageDto;
import com.example.mq.properties.RabbitMqProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqService {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqProperties rabbitMqProperties;

    public void sendMessage(MessageDto messageDto) {
        log.info("send message [{}]", messageDto);
        rabbitTemplate.convertAndSend(rabbitMqProperties.getExchangeName(), rabbitMqProperties.getRoutingKey(), messageDto);
    }
    // sample app이므로 리스너도 함께 구현
    @RabbitListener(queues = "${spring.rabbitmq.queue-name}")
    public void receiveMessage(MessageDto messageDto) {
        log.info("received message [{}]", messageDto);
    }
}
