package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.MoviesDTO;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MoviesMapper {
    public MoviesModel movieDTOtoModel(MoviesDTO dto){
        MoviesModel moviesModel = new MoviesModel();
        moviesModel.setId(dto.getId());
        moviesModel.setImage(dto.getImage());
        moviesModel.setTitle(dto.getTitle());
        moviesModel.setCreationDate(dto.getCreationDate());
        moviesModel.setQuealification(dto.getQualification());
        return moviesModel;
    }
    public MoviesDTO moviesModeltoDTO(MoviesModel moviesModel){
        MoviesDTO dto = new MoviesDTO();
        dto.setId(moviesModel.getId());
        dto.setImage(moviesModel.getImage());
        dto.setTitle(moviesModel.getTitle());
        dto.setCreationDate(moviesModel.getCreationDate());
        dto.setQualification(moviesModel.getQuealification());
        return dto;
    }
    public List<MoviesDTO>moviesModelListtoDTOList(List<MoviesModel> models){
        List<MoviesDTO> dtos = new ArrayList<>();
        for (MoviesModel model:models) {
            dtos.add(moviesModeltoDTO(model));
        }
        return dtos;
    }
}
