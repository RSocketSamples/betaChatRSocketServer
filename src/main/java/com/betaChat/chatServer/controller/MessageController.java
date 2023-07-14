package com.betaChat.chatServer.controller;

import com.betaChat.chatServer.dto.MessageRequest;
import com.betaChat.chatServer.dto.MessageStatus;
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
    public Mono<MessageRequest> sendMessage(Mono<MessageRequest> request){
        return request
                .doOnNext(t -> t.setStatus(MessageStatus.DELIVERY))
                .doOnNext(t -> System.out.println("Message :: " + t.getBody() + " : " + t.getSender() + " : " + t.getStatus()));
    }

}
