package com.example.diploma.repositories;

import com.example.diploma.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin, Long> {
    Optional<Admin>findByName(String name);
}
