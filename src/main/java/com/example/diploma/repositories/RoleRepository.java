package com.example.diploma.repositories;

import com.example.diploma.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role, Long> {
    Optional<Role>findByName(String name);
}
