package com.test.api.marvel_challenge.persitence.integration.marvel.dto;

public record CharacterDto(
        Long id,
        String name,
        String description,
        String modified,
        String resourceURI

) {
    public static record CharacterInfoDto(
            String imagePath,
            String description
    ) {

    }
}
