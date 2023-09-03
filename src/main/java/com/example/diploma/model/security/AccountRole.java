package com.example.diploma.model.security;

import org.springframework.security.core.GrantedAuthority;

public enum AccountRole implements GrantedAuthority {
    USER,

    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
