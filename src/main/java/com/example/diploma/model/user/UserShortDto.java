package com.example.diploma.model.user;

import lombok.Value;

@Value
public class UserShortDto {
    long id;

    String name;

    public static UserShortDto from(User user){
        return new UserShortDto(
                user.getId(),
                user.getUsername()
        );
    }
}
