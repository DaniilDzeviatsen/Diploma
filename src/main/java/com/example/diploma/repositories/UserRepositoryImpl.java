package com.example.diploma.repositories;

import com.example.diploma.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl extends BaseJpaRepository<User, Long> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT user
                        FROM User user
                        WHERE lower(user.email)=lower(:email) 
                        """, User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
