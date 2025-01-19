package com.test.api.marvel_challenge.persitence.integration.marvel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.test.api.marvel_challenge.persitence.integration.marvel.dto.CharacterDto;
import com.test.api.marvel_challenge.persitence.integration.marvel.dto.ThumbnailDto;

import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {

    public static List<CharacterDto> toDtoList(JsonNode rootNode) {
        ArrayNode resultNode = getResultsNode(rootNode);

        List<CharacterDto> characters = new ArrayList<>();
        resultNode.elements().forEachRemaining( each -> {
            characters.add(CharacterMapper.toDto(each));
        });

        return characters;

    }

    private static CharacterDto toDto(JsonNode characterNode) {
        if (characterNode == null) {
            throw new IllegalArgumentException("el nodo json no puede ser null");
        }
        CharacterDto dto = new CharacterDto(
                Long.parseLong(characterNode.get("id").asText()),
                characterNode.get("name").asText(),
                characterNode.get("description").asText(),
                characterNode.get("modified").asText(),
                characterNode.get("resourceURI").asText()
        );
        return dto;
    }

    private static ArrayNode getResultsNode(JsonNode rootNode) {
        if (rootNode == null) {
            throw new IllegalArgumentException("el nodo json no puede ser null");
        }

        JsonNode dataNode = rootNode.get("data");
        return (ArrayNode) dataNode.get("results");
    }

    public static List<CharacterDto.CharacterInfoDto> toInfoDtoList(JsonNode response) {
        ArrayNode resultsNode = resultsNode = getResultsNode(response);

        List<CharacterDto.CharacterInfoDto> characters = new ArrayList<>();
        resultsNode.elements().forEachRemaining(each -> {
            characters.add(CharacterMapper.toInfoDto(each));
        });

        return characters;
    }

    private static CharacterDto.CharacterInfoDto toInfoDto(JsonNode characterNode) {
        if (characterNode == null) {
            throw new IllegalArgumentException("el node json no puede ser null");
        }

        JsonNode thumbnailNode = characterNode.get("thumbnail");
        ThumbnailDto thumbnailDto = new ThumbnailDto(
                thumbnailNode.get("path").asText(),
                thumbnailNode.get("description").asText()
        );

        String image = thumbnailDto.path().concat(".").concat(thumbnailDto.extension());

        CharacterDto.CharacterInfoDto dto = new CharacterDto.CharacterInfoDto(
                image,
                characterNode.get("description").asText()
        );

        return dto;
    }
}
