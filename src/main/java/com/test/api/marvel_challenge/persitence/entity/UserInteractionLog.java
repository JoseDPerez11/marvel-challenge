package com.test.api.marvel_challenge.persitence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserInteractionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String url;
    private String httpMethod;
    private String username;
    private LocalDateTime timestamp;
    private String remoteAddress;
}
