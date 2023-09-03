package com.example.diploma.repositories;

import com.example.diploma.model.poem.Poem;

import java.util.List;
import java.util.Optional;

public interface PoemRepository extends BaseRepository<Poem, Long> {

    List<Poem> findAllPoemsByUser(String userName, int pageSize, int pageNumber);

    Optional<Poem> findByIdWithUser(long poemId);
}
