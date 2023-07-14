package com.betaChat.chatServer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private int id;
    private String sender;
    private String body;
}
