package com.test.api.marvel_challenge.service.impl;

import com.test.api.marvel_challenge.dto.GetUserInteractionLogDto;
import com.test.api.marvel_challenge.mapper.UserInteractionLogMapper;
import com.test.api.marvel_challenge.persitence.repository.UserInteractionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserInteractionLogServiceImpl implements UserInteractionLogService {

    @Autowired
    private UserInteractionLogRepository userInteractionLogRepository;

    @Override
    public Page<GetUserInteractionLogDto> findAll(Pageable pageable) {
        return userInteractionLogRepository.findAll(pageable)
                .map(UserInteractionLogMapper::toDto);
    }

    @Override
    public Page<GetUserInteractionLogDto> findByUsername(Pageable pageable, String username) {
        return userInteractionLogRepository.findByUsername(pageable, username)
                .map(UserInteractionLogMapper::toDto);
    }
}
