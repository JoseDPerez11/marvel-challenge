package com.test.api.marvel_challenge.service.impl;

import com.test.api.marvel_challenge.dto.GetUserInteractionLogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserInteractionLogService {
    Page<GetUserInteractionLogDto> findAll(Pageable pageable);

    Page<GetUserInteractionLogDto> findByUsername(Pageable pageable, String username);
}
