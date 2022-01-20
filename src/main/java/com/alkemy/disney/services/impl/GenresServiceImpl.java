package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.GenresDTO;
import com.alkemy.disney.mapper.GenresMapper;
import com.alkemy.disney.models.GenresModel;
import com.alkemy.disney.repositories.GenresRepository;
import com.alkemy.disney.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {
    @Autowired
    private GenresMapper genresMapper;
    @Autowired
    private GenresRepository genresRepository;
    public GenresDTO addGenre(GenresDTO dto){
        GenresModel genresModel = genresMapper.genresDTOtoModel(dto);
        GenresModel addedGenreModel = genresRepository.save(genresModel);
        GenresDTO result = genresMapper.genresModeltoDTO(addedGenreModel);
        return result;
    }
    public List<GenresDTO> getAllGenres() {
        List<GenresModel> models = genresRepository.findAll();
        List<GenresDTO> result = genresMapper.genresModelListtoDTOList(models);
        return result;
    }
}
