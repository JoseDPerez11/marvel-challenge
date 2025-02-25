package com.test.api.marvel_challenge.persitence.integration.marvel.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.test.api.marvel_challenge.persitence.integration.marvel.dto.ThumbnailDto;

public class ThumbnailMapper {

    public static ThumbnailDto toDto(JsonNode thumbnailNode) {
        if (thumbnailNode == null) {
            throw new IllegalArgumentException("el nodo json no puede ser null");
        }

        ThumbnailDto dto = new ThumbnailDto(
                thumbnailNode.get("path").asText(),
                thumbnailNode.get("extension").asText()
        );

        return dto;
    }
}
