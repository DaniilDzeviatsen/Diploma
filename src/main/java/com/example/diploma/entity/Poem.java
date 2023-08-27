package com.example.diploma.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Table(name = "poems")
@Getter
@Setter
@Accessors(chain = true)
public class Poem extends BaseEntity{


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn (name="user_id", nullable = false)
    private User user;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "likes")
    private int numOfLikes;

}
