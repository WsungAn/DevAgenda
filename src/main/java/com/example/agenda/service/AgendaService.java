package com.example.agenda.service;

import com.example.agenda.dto.*;
import com.example.agenda.entity.Agenda;
import com.example.agenda.repository.AgendaRepository;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final UserRepository userRepository;

    @Transactional
    public CreateAgendaResponse save(Long userId, CreateAgendaRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );

        Agenda agenda = new Agenda(
                request.getAuthor(),
                request.getTitle(),
                request.getContent(),
                user);
        Agenda savedAgenda = agendaRepository.save(agenda);
        return new CreateAgendaResponse(
                savedAgenda.getId(),
                savedAgenda.getTitle(),
                savedAgenda.getContent(),
                savedAgenda.getAuthor(),
                savedAgenda.getCreatedAt(),
                savedAgenda.getModifiedAt()
        );
    }


    @Transactional(readOnly = true)
    public GetAgendaResponse getOne(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new GetAgendaResponse(
                agenda.getId(),
                agenda.getTitle(),
                agenda.getContent(),
                agenda.getAuthor(),
                agenda.getCreatedAt(),
                agenda.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetAgendaResponse> getAll(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );

        List<Agenda> agendas = agendaRepository.findByUser(user);
        return agendas.stream()
                .map(agenda -> new GetAgendaResponse(
                        agenda.getId(),
                        agenda.getTitle(),
                        agenda.getContent(),
                        agenda.getAuthor(),
                        agenda.getCreatedAt(),
                        agenda.getModifiedAt()
                ))
                .toList();
    }


    @Transactional
    public UpdateAgendaResponse update(Long agendaId, UpdateAgendaRequest request) {
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        agenda.update(request.getTitle(), request.getAuthor());
        return new UpdateAgendaResponse(
                agenda.getId(),
                agenda.getTitle(),
                agenda.getContent(),
                agenda.getAuthor()
        );

    }

    @Transactional
    public void delete(Long agendaId) {
        boolean existence = agendaRepository.existsById(agendaId);
        if (!existence) {
            throw new IllegalArgumentException("없는 일정입니다.");
        }
        agendaRepository.deleteById(agendaId);
    }
}


