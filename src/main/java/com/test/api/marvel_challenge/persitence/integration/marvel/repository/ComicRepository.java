package com.test.api.marvel_challenge.persitence.integration.marvel.repository;

import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persitence.integration.marvel.dto.ComicDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComicRepository {
    public List<ComicDto> findAll(MyPageable pageable, Long characterId) {
        return null;
    }

    public ComicDto findById(Long comicId) {
        return null;
    }
}
