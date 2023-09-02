package com.example.diploma.model.user;

import lombok.Value;

@Value
public class UserSignUpDto {
    String email;

    String password;

    String username;
}
