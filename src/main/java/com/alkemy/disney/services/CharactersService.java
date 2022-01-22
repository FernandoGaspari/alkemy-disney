package com.alkemy.disney.services;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;

import java.util.List;

public interface CharactersService {
    CharactersDTO addCharacter(CharactersDTO character);
    List<CharactersDTO> getAllCharacters();
    List<CharactersSimplDTO> getAllCharactersSimpl();
    void deleteCharacter(Long id);

    CharactersDTO updateCharacter(Long id, CharactersDTO character);
}
