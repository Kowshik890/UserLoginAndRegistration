package com.example.UserLoginAndRegistration.controller;

import com.example.UserLoginAndRegistration.model.RegistrationRequest;
import com.example.UserLoginAndRegistration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor    // using lombok instead of using constructors
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {

        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String config(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }
}
