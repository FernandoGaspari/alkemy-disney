package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersDetailsDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CharactersMapper {
    public CharactersModel charactersDTOtoModel(CharactersDTO dto){
        CharactersModel charactersModel = new CharactersModel();
        charactersModel.setId(dto.getId());
        charactersModel.setImage(dto.getImage());
        charactersModel.setName(dto.getName());
        charactersModel.setAge(dto.getAge());
        charactersModel.setWeight(dto.getWeight());
        charactersModel.setHistory(dto.getHistory());
        return charactersModel;
    }
    public CharactersDTO charactersModeltoDTO(CharactersModel charactersModel){
        CharactersDTO dto = new CharactersDTO();
        dto.setId(charactersModel.getId());
        dto.setImage(charactersModel.getImage());
        dto.setName(charactersModel.getName());
        dto.setAge(charactersModel.getAge());
        dto.setWeight(charactersModel.getWeight());
        dto.setHistory(charactersModel.getHistory());
        dto.setMovies(charactersModel.getMovies());
        return dto;
    }

    public CharactersDetailsDTO charactersModeltoCharactersDetailsDTO(CharactersModel charactersModel){
        CharactersDetailsDTO dto = new CharactersDetailsDTO();
        dto.setId(charactersModel.getId());
        dto.setImage(charactersModel.getImage());
        dto.setAge(charactersModel.getAge());
        dto.setHistory(charactersModel.getHistory());
        dto.setWeight(charactersModel.getWeight());
        dto.setName(charactersModel.getName());
        Set<String> titles = new HashSet<>();
        for (MoviesModel movie:charactersModel.getMovies()) {
            titles.add(movie.getTitle());
        }
        dto.setMovies(titles);
        return dto;
    }

    public List<CharactersDTO> charactersModelListtoDTOList(List<CharactersModel> models){
        List<CharactersDTO> dtos = new ArrayList<>();
        for (CharactersModel model:models) {
            dtos.add(charactersModeltoDTO(model));
        }
        return dtos;
    }

    public CharactersSimplDTO charactersModelSimpltoDTO(CharactersModel charactersModel){
        CharactersSimplDTO dto = new CharactersSimplDTO();
        dto.setImage(charactersModel.getImage());
        dto.setName(charactersModel.getName());
        return dto;
    }

    public List<CharactersSimplDTO> charactersModelListtoDTOSimplList(List<CharactersModel> models){
        List<CharactersSimplDTO> dtos = new ArrayList<>();
        for (CharactersModel model:models) {
            dtos.add(charactersModelSimpltoDTO(model));
        }
        return dtos;
    }

    public List<CharactersDTO>characterModelSettoCharacterDTOList(Collection<CharactersModel> models){
        List<CharactersDTO>dtos=new ArrayList<>();
        for (CharactersModel model:models){
            dtos.add(charactersModeltoDTO(model));
        }
        return dtos;
    }

    public List<CharactersDetailsDTO> charactersModeltoListCharactersDetailsDTO(List<CharactersModel> models) {
        List<CharactersDetailsDTO> dtos = new ArrayList<>();
        for (CharactersModel model:models) {
            dtos.add(charactersModeltoCharactersDetailsDTO(model));
        }
        return dtos;
    }
}
