package com.userservice.services;

import com.userservice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long Id);

    List<UserDto> getUsers();

    UserDto createUser(UserDto userDto);

}
