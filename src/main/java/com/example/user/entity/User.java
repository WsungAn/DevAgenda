package com.example.user.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String username;
    @Column(unique = true, nullable = false,length = 50)
    private String email;
    @Column(nullable = false,length = 20)
    private String password;
    @Column(nullable = false, length = 100)
    LocalDateTime createdAt;
    @Column(nullable = false, length = 100)
    LocalDateTime modifiedAt;


    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void update(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
