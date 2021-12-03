package com.example.UserLoginAndRegistration.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter               // using lombok instead of using getter, setter methods
@AllArgsConstructor   // using lombok instead of using constructors
@EqualsAndHashCode
@ToString             // using lombok instead of using ToString method
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;

}
