package com.betaChat.chatServer.service;

import com.betaChat.chatServer.dto.UserRequest;
import com.betaChat.chatServer.entity.User;
import com.betaChat.chatServer.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Mono<User> saveUser(Mono<UserRequest> request) {
        return request.flatMap(userRequest -> {
            User user = new User();
            user.setNickname(userRequest.getNickname());
            return userRepository.save(user);
        });
    }
}
