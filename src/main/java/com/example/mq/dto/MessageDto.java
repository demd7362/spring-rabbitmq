package com.example.mq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDto {
    private String sender;
    private String receiver;
    private String message;
}
