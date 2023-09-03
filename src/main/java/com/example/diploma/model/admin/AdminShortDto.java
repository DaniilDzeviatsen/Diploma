package com.example.diploma.model.admin;

import lombok.Value;

import java.net.URI;

@Value
public class AdminShortDto {
    long id;

    String name;

    String email;

    public static AdminShortDto from(Admin admin) {
        return new AdminShortDto(
                admin.getId(),
                admin.getName(),
                admin.getEmail()
        );
    }
}
