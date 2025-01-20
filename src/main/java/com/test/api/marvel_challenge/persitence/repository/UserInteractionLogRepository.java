package com.test.api.marvel_challenge.persitence.repository;

import com.test.api.marvel_challenge.persitence.entity.UserInteractionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInteractionLogRepository extends JpaRepository<UserInteractionLog, Long> {
}
