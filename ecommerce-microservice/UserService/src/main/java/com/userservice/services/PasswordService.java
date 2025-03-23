package com.userservice.services;

public interface PasswordService {

    String hashPassword(String plainPassword);

    boolean verifyPassword(String rawPassword, String hashedPassword);

}
