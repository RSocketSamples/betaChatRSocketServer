package com.betaChat.chatServer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.betaChat.chatServer.entity.Message;

public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
}
