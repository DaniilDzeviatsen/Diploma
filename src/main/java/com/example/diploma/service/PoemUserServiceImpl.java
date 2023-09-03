package com.example.diploma.service;

import com.example.diploma.exception.BusinessException;
import com.example.diploma.model.poem.Poem;
import com.example.diploma.model.poem.PoemDto;
import com.example.diploma.model.poem.PoemUpdateDto;
import com.example.diploma.model.security.UserPrincipal;
import com.example.diploma.model.user.User;
import com.example.diploma.repositories.PoemRepository;
import com.example.diploma.repositories.UserRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PoemUserServiceImpl implements PoemUserService {

    public static final int POEMS_PAGE_SIZE = 10;

    private final PoemRepository poemRepo;

    private final UserRepository userRepo;

    @Override
    @Transactional(readOnly = true)
    public List<PoemDto> getPageByAuthor(String authorName, int pageNumber) {
        String dbAuthorName = "%" + authorName + "%";
        return poemRepo.findAllPoemsByUser(dbAuthorName, POEMS_PAGE_SIZE, pageNumber)
                .stream()
                .map(PoemDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PoemDto getById(long id, @Nullable UserPrincipal principal) {
        Poem poem = poemRepo.findByIdWithUser(id)
                .orElseThrow(() -> new BusinessException("Poem is not found"));
        return PoemDto.from(poem);
    }

    @Override
    @Transactional
    public PoemDto update(long id, PoemUpdateDto dto, UserPrincipal principal) {
        Poem poem = poemRepo.findByID(id)
                .orElseThrow(() -> new BusinessException("Poem is not found"));
        validateAccess(poem, principal);
        poem.setTitle(dto.getTitle());
        poem.setContent(dto.getContent());
        return PoemDto.from(poem);
    }

    @Override
    @Transactional
    public PoemDto create(PoemUpdateDto dto, UserPrincipal principal) {
        Instant createdAt = Instant.now();
        User user = userRepo.getReferenceById(principal.getId());
        Poem poem = new Poem()
                .setUser(user)
                .setCreatedAt(createdAt)
                .setContent(dto.getContent())
                .setTitle(dto.getTitle());
        poemRepo.create(poem);
        return PoemDto.from(poem);
    }

    private void validateAccess(Poem poem, UserPrincipal principal) {
        long authenticatedId = principal.getId();
        long ownerId = poem.getUser().getId();
        if (authenticatedId != ownerId) {
            throw new BusinessException("Access denied");
        }
    }
}
