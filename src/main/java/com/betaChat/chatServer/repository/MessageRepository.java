package com.betaChat.chatServer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.betaChat.chatServer.entity.Message;
import reactor.core.publisher.Flux;

public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
    Flux<Message> findAllByOrderByCreatedAtDesc();
}
