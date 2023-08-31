package com.betaChat.chatServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.betaChat.chatServer.dto.MessageRequest;
import com.betaChat.chatServer.entity.Message;
import com.betaChat.chatServer.service.MessageService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("create.message")
    public Mono<Void> sendMessage(Mono<MessageRequest> request){
         messageService.saveMessage(request).subscribe();
         return Mono.empty();
    }

    @MessageMapping("list.messages")
    public Flux<Message> getMessages(){
        return messageService.getAllMessages();
    }
}
