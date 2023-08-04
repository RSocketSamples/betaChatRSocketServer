package com.betaChat.chatServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.betaChat.chatServer.dto.UserRequest;
import com.betaChat.chatServer.entity.User;
import com.betaChat.chatServer.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @MessageMapping("create.user")
    public Mono<User> sendMessage(Mono<UserRequest> request){
        return userService.saveUser(request);
    }

    @MessageMapping("list.user")
    public Flux<User> getMessages(){
        return userService.getAllUsers();
    }

}
