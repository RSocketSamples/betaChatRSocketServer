package com.betaChat.chatServer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class MessageRequest {


    private String sender;
    private String body;
    private MessageStatus status = MessageStatus.SEND;

}
