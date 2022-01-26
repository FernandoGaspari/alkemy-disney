package com.alkemy.disney.services;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersDetailsDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;

import java.util.List;
import java.util.Set;

public interface CharactersService {
    CharactersDTO addCharacter(CharactersDTO character);
    CharactersDetailsDTO getAllCharacters(Long id);
    List<CharactersSimplDTO> getAllCharactersSimpl();
    void deleteCharacter(Long id);

    CharactersDTO updateCharacter(Long id, CharactersDTO character);

    List<CharactersDTO> getByFilters(String name, Short age, Set<Long> idMovies);
}
