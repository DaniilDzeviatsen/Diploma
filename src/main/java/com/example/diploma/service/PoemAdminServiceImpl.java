package com.example.diploma.service;

import com.example.diploma.exception.BusinessException;
import com.example.diploma.model.poem.Poem;
import com.example.diploma.model.poem.PoemBannedDto;
import com.example.diploma.model.poem.PoemDto;
import com.example.diploma.model.security.AdminPrincipal;
import com.example.diploma.model.security.UserPrincipal;
import com.example.diploma.repositories.AdminRepository;
import com.example.diploma.repositories.PoemRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PoemAdminServiceImpl implements PoemAdminService {

    public static final int POEMS_PAGE_SIZE = 10;

    private final PoemRepository poemRepo;

    private final AdminRepository adminRepo;

    @Override
    @Transactional
    public PoemBannedDto update(long id, PoemBannedDto dto, AdminPrincipal principal) {
        Poem poem = poemRepo.findByID(id)
                .orElseThrow(() -> new BusinessException("Poem is not found"));
        poem.setTitle("Banned poem");
        poem.setContent("Content is not available");

        return PoemBannedDto.from(poem);
    }

}
