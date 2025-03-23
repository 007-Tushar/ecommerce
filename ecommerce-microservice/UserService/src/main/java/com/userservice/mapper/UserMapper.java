package com.userservice.mapper;

import com.userservice.dto.UserDto;
import com.userservice.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert DTO to Entity
    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhone(),
                userDto.getRole());
    }

    // Convert Entity to DTO
    public UserDto toDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getRole());
    }
}