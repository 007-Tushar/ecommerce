package com.userservice.mapper;

import com.userservice.dto.UserDto;
import com.userservice.dto.UserRequest;
import com.userservice.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert DTO to Entity
    public User toEntity(UserRequest userRequest) {
        return new User(
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getEmail(),
                userRequest.getPassword(),
                userRequest.getPhone(),
                userRequest.getRole());
    }

    // Convert Entity to DTO
    public UserDto toDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole());
    }
}