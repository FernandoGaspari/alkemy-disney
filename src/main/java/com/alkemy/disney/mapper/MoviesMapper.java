package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MoviesMapper {
    public MoviesModel movieDTOtoModel(MoviesDTO dto){
        MoviesModel moviesModel = new MoviesModel();
        moviesModel.setId(dto.getId());
        moviesModel.setImage(dto.getImage());
        moviesModel.setTitle(dto.getTitle());
        moviesModel.setCreationDate(dto.getCreationDate());
        moviesModel.setQualification(dto.getQualification());
        return moviesModel;
    }
    public MoviesDTO moviesModeltoDTO(MoviesModel moviesModel){
        MoviesDTO dto = new MoviesDTO();
        dto.setId(moviesModel.getId());
        dto.setImage(moviesModel.getImage());
        dto.setTitle(moviesModel.getTitle());
        dto.setCreationDate(moviesModel.getCreationDate());
        dto.setQualification(moviesModel.getQualification());
        dto.setCharacters(moviesModel.getCharacters());
        return dto;
    }

    public MoviesDetailsDTO moviesModeltoMoviesDetailDTO(MoviesModel moviesModel){
        MoviesDetailsDTO dto = new MoviesDetailsDTO();
        dto.setId(moviesModel.getId());
        dto.setImage(moviesModel.getImage());
        dto.setTitle(moviesModel.getTitle());
        dto.setCreationDate(moviesModel.getCreationDate());
        dto.setQualification(moviesModel.getQualification());
        Set<String>names = new HashSet<>();
        for (CharactersModel character:moviesModel.getCharacters()) {
            names.add(character.getName());
        }
        dto.setCharacters(names);
        return dto;

    }

    public List<MoviesDTO>moviesModelListtoDTOList(List<MoviesModel> models){
        List<MoviesDTO> dtos = new ArrayList<>();
        for (MoviesModel model:models) {
            dtos.add(moviesModeltoDTO(model));
        }
        return dtos;
    }

    public List<MoviesDTO>movieModelSettoMovieDTOList(Collection<MoviesModel> models){
        List<MoviesDTO>dtos=new ArrayList<>();
        for (MoviesModel model:models){
            dtos.add(moviesModeltoDTO(model));
        }
        return dtos;
    }

    public MoviesSimplDTO moviesModelSimpltoDTO(MoviesModel moviesModel){
        MoviesSimplDTO dto = new MoviesSimplDTO();
        dto.setImage(moviesModel.getImage());
        dto.setTitle(moviesModel.getTitle());
        dto.setCreationDate(moviesModel.getCreationDate());
        return dto;
    }

    public List<MoviesSimplDTO> moviesModelListtoDTOSimplList(List<MoviesModel> models){
        List<MoviesSimplDTO> dtos = new ArrayList<>();
        for (MoviesModel model:models) {
            dtos.add(moviesModelSimpltoDTO(model));
        }
        return dtos;
    }

    public List<MoviesDetailsDTO> moviesModeltoListMoviesDetailsDTO(List<MoviesModel> models) {
        List<MoviesDetailsDTO> dtos = new ArrayList<>();
        for (MoviesModel model:models) {
            dtos.add(moviesModeltoMoviesDetailDTO(model));
        }
        return dtos;
    }
}
