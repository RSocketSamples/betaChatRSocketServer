package com.betaChat.chatServer.service;

import com.betaChat.chatServer.dto.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final List<Message> messages = List.of(
            new Message(1, "brayan.herrera", "HolaPragma"),
            new Message(2, "jhoan.stiven", "👍"),
            new Message(3, "brayan.herrera", "👍")
    );

    public List<Message> getMessages() {
        return messages;
    }

    public Message getMessage(int index) {
        return this.messages.get(index);
    }
}
