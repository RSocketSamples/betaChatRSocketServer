package com.betaChat.chatServer.controller;

import com.betaChat.chatServer.dto.Message;
import com.betaChat.chatServer.dto.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import com.betaChat.chatServer.service.MessageService;
import reactor.core.publisher.Mono;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("send")
    public Mono<Message> sendMessage(Mono<MessageRequest> request){
        return messageService.saveMessage(request);
    }
}
