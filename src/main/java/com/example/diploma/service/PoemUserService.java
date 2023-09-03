package com.example.diploma.service;

import com.example.diploma.model.poem.PoemDto;
import com.example.diploma.model.poem.PoemUpdateDto;
import com.example.diploma.model.security.UserPrincipal;
import jakarta.annotation.Nullable;

import java.util.List;

public interface PoemUserService {
    List<PoemDto> getPageByAuthor(String authorName, int pageNumber);


    PoemDto getById(long id, @Nullable UserPrincipal principal);

    PoemDto update(long id, PoemUpdateDto dto, UserPrincipal principal);

    PoemDto create(PoemUpdateDto dto, UserPrincipal principal);

}
