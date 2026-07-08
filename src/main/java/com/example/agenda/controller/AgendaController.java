package com.example.agenda.controller;

import com.example.agenda.dto.*;
import com.example.agenda.service.AgendaService;
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

    @PostMapping("/{agendaId}/users")
    public ResponseEntity<CreateAgendaResponse> create(@PathVariable Long userId, @RequestBody CreateAgendaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.save(userId, request));
    }

    @GetMapping("/{agendaId}/users")
    public ResponseEntity<List<GetAgendaResponse>> getAll(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.getAll(userId));
    }

    @GetMapping("/{agendaId}/users/{userId}")
    public ResponseEntity<GetAgendaResponse> getOne(@PathVariable Long agendaId){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.getOne(agendaId));
    }

    @PutMapping("/{agendaId}/users/{userId}")
    public ResponseEntity<UpdateAgendaResponse> update(@PathVariable Long agendaId, @RequestBody UpdateAgendaRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.update(agendaId, request));
    }

    @DeleteMapping("/{agendaId}/users/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long agendaId) {
        agendaService.delete(agendaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
