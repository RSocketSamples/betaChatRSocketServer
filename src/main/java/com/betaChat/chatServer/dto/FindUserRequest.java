package com.betaChat.chatServer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindUserRequest {
    private String id;
    private String nickname;
}
