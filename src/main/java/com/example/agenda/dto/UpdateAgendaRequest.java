package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class UpdateAgendaRequest {
    private String title;
    private String author;
    private String password;
}
