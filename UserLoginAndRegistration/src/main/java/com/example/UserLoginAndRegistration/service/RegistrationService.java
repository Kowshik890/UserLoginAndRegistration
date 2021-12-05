package com.example.UserLoginAndRegistration.service;

import com.example.UserLoginAndRegistration.email.EmailValidator;
import com.example.UserLoginAndRegistration.model.AppUser;
import com.example.UserLoginAndRegistration.model.AppUserRole;
import com.example.UserLoginAndRegistration.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isEmailValid = emailValidator.test(request.getEmail());

        if(!isEmailValid) {
            throw new IllegalStateException("Email is not valid.");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
