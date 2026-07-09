package com.example.agenda.controller;

import com.example.agenda.dto.*;
import com.example.agenda.service.AgendaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendas")
public class AgendaController {
    private final AgendaService agendaService;

    @PostMapping("/{agendaId}")
    public ResponseEntity<CreateAgendaResponse> create(@RequestBody CreateAgendaRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("LOGIN_USER");
        if (userId == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.save(userId, request));
    }

    @GetMapping
    public ResponseEntity<List<GetAgendaResponse>> getAll(HttpSession session) {
        Long userId = (Long) session.getAttribute("LOGIN_USER");
        if (userId == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }return ResponseEntity.ok(agendaService.getAll(userId));
    }


    @GetMapping("/{agendaId}/users/{userId}")
    public ResponseEntity<GetAgendaResponse> getOne(@PathVariable Long agendaId){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.getOne(agendaId));
    }

    @PutMapping("/{agendaId}")
    public ResponseEntity<UpdateAgendaResponse> update(
            @PathVariable Long agendaId,
            @RequestBody UpdateAgendaRequest request,
            HttpSession session){
        Long userId = (Long) session.getAttribute("LOGIN_USER");
        if (userId == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.update(agendaId, request));
    }

    @DeleteMapping("/{agendaId}")
    public ResponseEntity<Void> delete(@PathVariable Long agendaId) {
        agendaService.delete(agendaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
