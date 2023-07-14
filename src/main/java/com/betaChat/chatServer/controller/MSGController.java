package com.betaChat.chatServer.controller;

import com.betaChat.chatServer.dto.Message;
import com.betaChat.chatServer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class MSGController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("messages")
    public Flux<Message> playMovie(Flux<Integer> sceneIndex){
        return sceneIndex
                .map(index -> index - 1)
                .map(this.messageService::getMessage)
                .delayElements(Duration.ofSeconds(1));
    }

}
