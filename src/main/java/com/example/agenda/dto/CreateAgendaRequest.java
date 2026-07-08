package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class CreateAgendaRequest {
    private String title;
    private String content;
    private String author;
    private String password;
}
