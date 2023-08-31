package com.betaChat.chatServer.service;

import com.betaChat.chatServer.dto.MessageRequest;
import com.betaChat.chatServer.entity.Message;
import com.betaChat.chatServer.entity.User;
import com.betaChat.chatServer.repository.MessageRepository;

import com.betaChat.chatServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> saveMessage(Mono<MessageRequest> request) {
        return request.flatMap(messageRequest -> {
            Mono<User> userMono = this.findUser(messageRequest.getSender());

            return userMono.flatMap(user -> {
                Message message = new Message();
                message.setSender(user);
                message.setBody(messageRequest.getBody());
                message.setCreatedAt(new Date());
                message.setUpdatedAt(new Date());
                return messageRepository.save(message);
            });
        });
    }

    public Mono<User> findUser(String idOrNickname) {
        if (idOrNickname != null && !idOrNickname.isEmpty()) {
            // Intenta buscar por ID
            Mono<User> userById = userRepository.findById(idOrNickname);

            // Si no se encuentra por ID, intenta buscar por nickname
            Mono<User> userByNickname = userById.switchIfEmpty(userRepository.findByNickname(idOrNickname));

            // Retorna el resultado, ya sea por ID o por nickname
            return userByNickname;
        }

        return Mono.empty(); // Si no se proporciona ni ID ni nickname, devuelve un Mono vacío
    }
}
