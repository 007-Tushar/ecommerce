package com.userservice.services.impl;

import com.userservice.services.PasswordService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String hashPassword(String plainPassword) {
        return bCryptPasswordEncoder.encode(plainPassword);
    }

    @Override
    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword,hashedPassword);
    }
}
