package com.betaChat.chatServer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.betaChat.chatServer.entity.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
