package com.betaChat.chatServer.service;

import com.betaChat.chatServer.dto.FindUserRequest;
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
            user.setProfileImage(userRequest.getProfileImage());
            return userRepository.save(user);
        });
    }

    public Mono<User> findUser(Mono<FindUserRequest> idOrNickname) {
        return idOrNickname.flatMap(request -> {
            if (request.getId() != null && !request.getId().isEmpty()) {
                // Intenta buscar por ID
                return userRepository.findById(request.getId())
                        .switchIfEmpty(userRepository.findByNickname(request.getId()));
            } else if (request.getNickname() != null && !request.getNickname().isEmpty()) {
                // Intenta buscar por nickname
                return userRepository.findByNickname(request.getNickname());
            } else {
                return Mono.empty(); // Si no se proporciona ni ID ni nickname, devuelve un Mono vacío
            }
        });
    }
}
