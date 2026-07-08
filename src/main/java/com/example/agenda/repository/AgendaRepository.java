package com.example.agenda.repository;

import com.example.agenda.entity.Agenda;
import com.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    List<Agenda> findByAuthor(String author);

    List<Agenda> findByUser(User user);
}
