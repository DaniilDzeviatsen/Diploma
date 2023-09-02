package com.example.diploma.model.user;

import lombok.Value;

@Value
public class UserSignInDto {

    String email;

    String username;

    String password;
}
