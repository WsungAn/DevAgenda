package com.example.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponse {
    private final Long id;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateUserResponse(Long id, String username, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
