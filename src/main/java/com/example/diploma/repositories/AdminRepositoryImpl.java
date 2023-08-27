package com.example.diploma.repositories;

import com.example.diploma.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminRepositoryImpl extends BaseJpaRepository<Admin, Long> implements AdminRepository {
    public AdminRepositoryImpl() {
        super(Admin.class);
    }

    @Override
    public Optional<Admin> findByName(String name) {
        return entityManager.createQuery("""
                        SELECT admin
                        FROM Admin admin
                        WHERE lower(admin.name)=lower(:name) 
                        """, Admin.class)
                .setParameter("name", name)
                .getResultStream()
                .findFirst();
    }
}
