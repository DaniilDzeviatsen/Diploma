package com.example.diploma.model.admin;

import lombok.Value;

import java.net.URI;

@Value
public class AdminSignUpDto {

    String email;

    String password;

    String name;

}
