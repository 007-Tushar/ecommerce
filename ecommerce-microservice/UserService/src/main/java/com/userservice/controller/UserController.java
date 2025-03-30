package com.userservice.controller;

import com.userservice.dto.UserDto;
import com.userservice.dto.UserRequest;
import com.userservice.services.PasswordService;
import com.userservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordService passwordService;

    public UserController(UserService userService, PasswordService passwordService) {
        this.userService = userService;
        this.passwordService = passwordService;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRequest userRequest) {
        userRequest.setPassword(passwordService.hashPassword(userRequest.getPassword()));
        UserDto createdUser = userService.createUser(userRequest); // Throws exception if user exists
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }



}
