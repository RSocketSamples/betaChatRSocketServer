package com.betaChat.chatServer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.betaChat.chatServer.entity.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByNickname(String nickname);
}
