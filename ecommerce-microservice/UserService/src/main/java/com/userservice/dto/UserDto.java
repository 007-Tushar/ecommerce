package com.userservice.dto;


import com.userservice.entities.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private Long userId;

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Email is required")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    @NotBlank(message = "Phone is required")
    private BigInteger phone;

    private Role role;
}
