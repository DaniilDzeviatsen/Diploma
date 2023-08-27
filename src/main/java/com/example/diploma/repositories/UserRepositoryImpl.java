package com.example.diploma.repositories;

import com.example.diploma.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl extends BaseJpaRepository<User, Long> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return entityManager.createQuery("""
                        SELECT user
                        FROM User user
                        WHERE lower(user.username)=lower(:username) 
                        """, User.class)
                .setParameter("username", username)
                .getResultStream()
                .findFirst();
    }
}
