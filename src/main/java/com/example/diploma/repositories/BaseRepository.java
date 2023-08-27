package com.example.diploma.repositories;

import jakarta.persistence.Id;

import java.util.Optional;

public interface BaseRepository<E, ID> {

    E getReferenceById(Id id);

    Optional<E> findByID(ID id);

    void create(E entity);

    void remove(E entity);
}
