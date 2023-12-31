package com.example.diploma.repositories;

import com.example.diploma.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    Optional <User> findByEmail(String email);
}
