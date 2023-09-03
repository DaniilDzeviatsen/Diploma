package com.example.diploma.model.poem;

import com.example.diploma.model.admin.AdminShortDto;
import com.example.diploma.model.user.UserDto;
import com.example.diploma.model.user.UserShortDto;
import lombok.Value;

@Value
public class PoemBannedDto {
    long id;

    UserShortDto user;

    String title;

    public static PoemBannedDto from(Poem poem){
        return new PoemBannedDto(
                poem.getId(),
                UserShortDto.from(poem.getUser()),
                poem.getTitle()
        );
    }
}
