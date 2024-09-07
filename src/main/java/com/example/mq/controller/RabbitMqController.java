package com.example.mq.controller;

import com.example.mq.dto.MessageDto;
import com.example.mq.service.RabbitMqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RabbitMqController {
    private final RabbitMqService rabbitMqService;

    @PostMapping("/send/message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto){
        rabbitMqService.sendMessage(messageDto);
        return ResponseEntity.ok("Message sent successfully");
    }
}
