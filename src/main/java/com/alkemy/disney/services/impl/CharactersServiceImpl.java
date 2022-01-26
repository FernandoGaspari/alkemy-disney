package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersDetailsDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.mapper.CharactersMapper;
import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.repositories.CharactersRepository;
import com.alkemy.disney.repositories.specifications.CharacterSpecification;
import com.alkemy.disney.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharactersServiceImpl implements CharactersService {
    @Autowired
    private CharactersMapper charactersMapper;
    @Autowired
    private CharactersRepository charactersRepository;
    @Autowired
    private CharacterSpecification characterSpecification;
    public CharactersDTO addCharacter(CharactersDTO dto){
        System.out.println("en service");
        CharactersModel charactersModel = charactersMapper.charactersDTOtoModel(dto);
        System.out.println("conversion a model");
        CharactersModel addedCharacterModel = charactersRepository.save(charactersModel);
        System.out.println("guardado listo");
        CharactersDTO result = charactersMapper.charactersModeltoDTO(addedCharacterModel);
        System.out.println("conversion a dto");
        return result;
    }
    public CharactersDetailsDTO getAllCharacters(Long id) {
        CharactersModel models = charactersRepository.getById(id);
        CharactersDetailsDTO result = charactersMapper.charactersModeltoCharactersDetailsDTO(models);
        return result;
    }

    public List<CharactersSimplDTO> getAllCharactersSimpl() {
        List<CharactersModel> models = charactersRepository.findAll();
        List<CharactersSimplDTO> result = charactersMapper.charactersModelListtoDTOSimplList(models);
        return result;
    }

    public List<CharactersDetailsDTO> getByFilters(String name, Short age, Set<Long> movies){
        List<CharactersModel> charactersModels = charactersRepository.findAll(characterSpecification.getByFilters(name, age, movies));
        List<CharactersDetailsDTO>dtos=charactersMapper.charactersModeltoListCharactersDetailsDTO(charactersModels);
        return dtos;
    }

    public CharactersDTO updateCharacter(Long id, CharactersDTO dto){
        CharactersModel charactersModel=charactersRepository.getById(id);
        charactersModel.setName(dto.getName());
        charactersModel.setImage(dto.getImage());
        charactersModel.setAge(dto.getAge());
        charactersModel.setWeight(dto.getWeight());
        charactersModel.setHistory(dto.getHistory());
        charactersModel=charactersRepository.save(charactersModel);
        CharactersDTO results = charactersMapper.charactersModeltoDTO(charactersModel);
        return results;

    }

    public void deleteCharacter(Long id) {
        this.charactersRepository.deleteById(id);
    }

}
