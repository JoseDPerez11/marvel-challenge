package com.test.api.marvel_challenge.persitence.repository;

import com.test.api.marvel_challenge.persitence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
