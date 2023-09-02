package com.example.diploma.repositories;

import com.example.diploma.model.admin.Admin;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin, Long> {
    Optional<Admin>findByEmail(String email);
}
