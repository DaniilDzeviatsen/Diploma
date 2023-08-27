package com.example.diploma.repositories;

import com.example.diploma.entity.Poem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PoemRepositoryImpl extends BaseJpaRepository<Poem, Long> implements PoemRepository {

    public PoemRepositoryImpl() {
        super(Poem.class);
    }

    @Override
    public List<Poem> findAllPoemsByUser(long userId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT poem
                        FROM Poem poem
                        WHERE poem.user.id = :userId
                        ORDER BY poem.createdAt DESC
                        """, Poem.class)
                .setParameter("userId", userId)
                .setMaxResults(pageSize)
                .setFirstResult(pageNumber + pageSize)
                .getResultList();
    }

    @Override
    public Optional<Poem> findByIdWithUser(long poemId) {
        return entityManager.createQuery("""
                        SELECT poem
                        FROM Poem poem
                        JOIN FETCH poem.user
                        WHERE poem.id =: poemId
                        """, Poem.class)
                .setParameter("poemId", poemId)
                .getResultStream()
                .findFirst();
    }
}
