package com.example.agenda.entity;


import com.example.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "agendas")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Agenda extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String author;
    @Column(nullable = false,length = 30)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false,length = 50)
    private String password;
    @Column(nullable = false, length = 100)
    LocalDateTime createdAt;
    @Column(nullable = false, length = 100)
    LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Agenda(String author, String title, String content, User user) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.user = user;
    }


    public void update(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
