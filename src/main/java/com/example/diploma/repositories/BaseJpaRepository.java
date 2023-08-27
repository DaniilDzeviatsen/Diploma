package com.example.diploma.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class BaseJpaRepository<E, ID> implements BaseRepository<E, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<E> entityClass;

    @Override
    public E getReferenceById(Id id) {
        return entityManager.getReference(entityClass, id);
    }

    @Override
    public Optional<E> findByID(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }
}
