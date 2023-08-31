package com.betaChat.chatServer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
    private String nickname;
    private String profileImage;
}
