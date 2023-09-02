package com.example.diploma.model.admin;

import com.example.diploma.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Table(name = "admin")
@Accessors (chain = true)
public class Admin extends BaseEntity {


    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false, unique = true)
    private String passwordHash;
}
