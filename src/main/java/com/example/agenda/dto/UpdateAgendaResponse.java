package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class UpdateAgendaResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;


    public UpdateAgendaResponse(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
