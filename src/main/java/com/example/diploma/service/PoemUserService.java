package com.example.diploma.service;

import com.example.diploma.model.poem.PoemDto;
import com.example.diploma.model.security.UserPrincipal;
import jakarta.annotation.Nullable;

import java.util.List;

public interface PoemUserService {
    List<PoemDto> getPageByUserPoems(String titleQuery, int pageNumber);


    PoemDto getById(long id, @Nullable UserPrincipal principal);

    PoemDto update(long id, PoemUpdateDto dto, UserPrincipal principal);

    PoemDto create(PoemCreateDto dto, UserPrincipal principal);

}
