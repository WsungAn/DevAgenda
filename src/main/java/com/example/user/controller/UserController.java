package com.example.user.controller;

import com.example.user.dto.*;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<GetUserResponse>> getAll(@RequestParam(required = false) String username) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll(username));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserResponse> getOne(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOne(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UpdateUserResponse> update(@PathVariable Long userId, @RequestBody UpdateUserRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @RequestBody DeleteUserRequest request){
        userService.delete(userId,request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
