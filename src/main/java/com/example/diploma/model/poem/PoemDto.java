package com.example.diploma.model.poem;

import com.example.diploma.model.user.UserDto;
import lombok.Value;

import java.time.Instant;

@Value
public class PoemDto {

    long id;

    UserDto user;

    String title;

    String content;

    Instant createdAt;

    public static PoemDto from(Poem poem) {
        return new PoemDto(
                poem.getId(),
                UserDto.from(poem.getUser()),
                poem.getTitle(),
                poem.getContent(),
                poem.getCreatedAt()
        );
    }
}
