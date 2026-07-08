package com.example.user.service;

import com.example.user.dto.*;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(
                request.getUsername(),
                request.getEmail()
        );
        User savedUser = userRepository.save(user);
        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }


    @Transactional(readOnly = true)
    public GetUserResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        return new GetUserResponse(
                user.getId(),
                user.getUsername(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetUserResponse> getAll(String username) {
        List<User> users;
        if (username == null || username.isBlank()) {
            users = userRepository.findAll();
        } else {
            users = userRepository.findByUsernameOrderByModifiedAtDesc(username);
        }
        List<GetUserResponse> dtos = new ArrayList<>();
        for (User user : users) {
            GetUserResponse dto = new GetUserResponse(
                    user.getId(),
                    user.getUsername(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }


    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        user.update(
                request.getUsername(),
                request.getEmail()
        );
        return new UpdateUserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );

    }

    @Transactional
    public void delete(Long userId, DeleteUserRequest request) {
        boolean existence = userRepository.existsById(userId);
        if (!existence) {
            throw new IllegalArgumentException("없는 일정입니다.");
        }

        User user = userRepository.findById(userId).get();
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

    }
}
