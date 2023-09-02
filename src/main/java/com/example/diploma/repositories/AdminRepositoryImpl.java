package com.example.diploma.repositories;

import com.example.diploma.model.admin.Admin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminRepositoryImpl extends BaseJpaRepository<Admin, Long> implements AdminRepository {
    public AdminRepositoryImpl() {
        super(Admin.class);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT admin
                        FROM Admin admin
                        WHERE lower(admin.email)=lower(:email) 
                        """, Admin.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
