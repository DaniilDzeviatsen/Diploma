package com.example.diploma.repositories;

import com.example.diploma.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryImpl extends BaseJpaRepository<Role, Long> implements RoleRepository {
    public RoleRepositoryImpl() {
        super(Role.class);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return entityManager.createQuery("""
                        SELECT role
                        FROM Role role
                        WHERE lower(role.name)=lower(:email) 
                        """, Role.class)
                .setParameter("name", name)
                .getResultStream()
                .findFirst();
    }
}
