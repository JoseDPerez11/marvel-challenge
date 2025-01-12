package com.test.api.marvel_challenge.persitence.integration.marvel.repository;

import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persitence.integration.marvel.dto.CharacterDto;
import com.test.api.marvel_challenge.persitence.integration.marvel.dto.ComicDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository {
    public List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series) {
        return null;
    }

    public CharacterDto.CharacterInfoDto findInfoById(Long characterId) {
        return null;
    }

}
