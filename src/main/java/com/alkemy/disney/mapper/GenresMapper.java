package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.GenresDTO;
import com.alkemy.disney.models.GenresModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenresMapper {
    public GenresModel genresDTOtoModel(GenresDTO dto){
        GenresModel genresModel = new GenresModel();
        genresModel.setId(dto.getId());
        genresModel.setImage(dto.getImage());
        genresModel.setName(dto.getName());
        return genresModel;
    }
    public GenresDTO genresModeltoDTO(GenresModel genresModel){
        GenresDTO dto = new GenresDTO();
        dto.setId(genresModel.getId());
        dto.setImage(genresModel.getImage());
        dto.setName(genresModel.getName());
        return dto;
    }
    public List<GenresDTO> genresModelListtoDTOList(List<GenresModel> models){
        List<GenresDTO> dtos = new ArrayList<>();
        for (GenresModel model:models) {
            dtos.add(genresModeltoDTO(model));
        }
        return dtos;
    }
}
