package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.mapper.CharactersMapper;
import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.repositories.CharactersRepository;
import com.alkemy.disney.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersServiceImpl implements CharactersService {
    @Autowired
    private CharactersMapper charactersMapper;
    @Autowired
    private CharactersRepository charactersRepository;
    public CharactersDTO addCharacter(CharactersDTO dto){
        CharactersModel charactersModel = charactersMapper.charactersDTOtoModel(dto);
        CharactersModel addedCharacterModel = charactersRepository.save(charactersModel);
        CharactersDTO result = charactersMapper.charactersModeltoDTO(addedCharacterModel);
        return result;
    }
    public List<CharactersDTO> getAllCharacters() {
        List<CharactersModel> models = charactersRepository.findAll();
        List<CharactersDTO> result = charactersMapper.charactersModelListtoDTOList(models);
        return result;
    }

    public List<CharactersSimplDTO> getAllCharactersSimpl() {
        List<CharactersModel> models = charactersRepository.findAll();
        List<CharactersSimplDTO> result = charactersMapper.charactersModelListtoDTOSimplList(models);
        return result;
    }

}
