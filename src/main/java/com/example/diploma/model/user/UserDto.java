package com.example.diploma.model.user;

import lombok.Value;

@Value
public class UserDto {
    String email;

    String username;

    public static UserDto from(User user){
        return new UserDto(
                user.getEmail(),
                user.getUsername()
        );
    }
}
