package com.test.api.marvel_challenge.mapper;

import com.test.api.marvel_challenge.dto.GetUserInteractionLogDto;
import com.test.api.marvel_challenge.persitence.entity.UserInteractionLog;

public class UserInteractionLogMapper {

    public static GetUserInteractionLogDto toDto(UserInteractionLog entity) {
        if (entity == null) return null;

        return new GetUserInteractionLogDto(
                entity.getId(),
                entity.getUrl(),
                entity.getHttpMethod(),
                entity.getUsername(),
                entity.getTimestamp(),
                entity.getRemoteAddress()
        );
    }
}
