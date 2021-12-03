package com.example.UserLoginAndRegistration.service;

import com.example.UserLoginAndRegistration.model.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {
        return "works";
    }
}
