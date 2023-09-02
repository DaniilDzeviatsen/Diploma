package com.example.diploma.model.security;

import com.example.diploma.model.user.User;
import lombok.Value;

@Value
public class UserPrincipal implements AccountPrincipal {
    long id;

    @Override
    public AccountRole getRole() {
        return AccountRole.USER;
    }

    public static UserPrincipal from(User user) {
        return new UserPrincipal(user.getId());
    }
}
