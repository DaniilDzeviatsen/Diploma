package com.example.diploma.model.security;

import com.example.diploma.model.admin.Admin;
import lombok.Value;

@Value
public class AdminPrincipal implements AccountPrincipal {
    long id;


    @Override
    public AccountRole getRole() {
        return AccountRole.ADMIN;
    }

    public static AdminPrincipal from(Admin admin) {
        return new AdminPrincipal(admin.getId());
    }
}
