package com.userservice.services;

import com.userservice.dto.UserDto;
import com.userservice.dto.UserRequest;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long Id);

    List<UserDto> getUsers();

    UserDto createUser(UserRequest userRequest);

}
