package com.example.diploma.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Collection;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email",unique = true)
    private String email;

}
