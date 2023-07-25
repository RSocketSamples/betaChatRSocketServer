package com.betaChat.chatServer.dto;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
}
