package com.example.diploma.repositories;

import com.example.diploma.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    Optional <User> findByUsername(String username);
}
