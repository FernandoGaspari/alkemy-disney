package com.alkemy.disney.services;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.GenresDTO;

import java.util.List;

public interface GenresService {
    GenresDTO addGenre(GenresDTO genre);
    List<GenresDTO> getAllGenres();
}
