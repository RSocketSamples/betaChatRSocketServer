package com.betaChat.chatServer.service;

import com.betaChat.chatServer.dto.Message;
import com.betaChat.chatServer.dto.MessageRepository;
import com.betaChat.chatServer.dto.MessageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> saveMessage(Mono<MessageRequest> request) {
        return request.flatMap(messageRequest -> {
            Message message = new Message();
            message.setSender(messageRequest.getSender());
            message.setBody(messageRequest.getBody());
            message.setCreatedAt(new Date());
            message.setUpdatedAt(new Date());
            return messageRepository.save(message);
        });
    }
}
