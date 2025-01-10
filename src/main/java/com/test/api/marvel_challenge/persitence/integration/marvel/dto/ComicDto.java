package com.test.api.marvel_challenge.persitence.integration.marvel.dto;

public record ComicDto(
        Long id,
        String title,
        String description,
        String modified,
        String resourceURI,
        ThumbnailDto thumbnail

) {
}
