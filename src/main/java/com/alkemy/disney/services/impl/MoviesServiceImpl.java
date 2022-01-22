package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.dto.MoviesSimplDTO;
import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.repositories.MoviesRepository;
import com.alkemy.disney.services.MoviesService;
import com.alkemy.disney.dto.MoviesDTO;
import com.alkemy.disney.mapper.MoviesMapper;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesMapper moviesMapper;
    @Autowired
    private MoviesRepository moviesRepository;
    public MoviesDTO addMovie(MoviesDTO dto){
        MoviesModel moviesModel = moviesMapper.movieDTOtoModel(dto);
        MoviesModel addedMovieModel = moviesRepository.save(moviesModel);
        MoviesDTO result = moviesMapper.moviesModeltoDTO(addedMovieModel);
        return result;
    }

    public List<MoviesDTO> getAllMovies() {
        List<MoviesModel> models = moviesRepository.findAll();
        List<MoviesDTO> result = moviesMapper.moviesModelListtoDTOList(models);
        return result;
    }
    public List<MoviesSimplDTO> getAllMoviesSimpl() {
        List<MoviesModel> models = moviesRepository.findAll();
        List<MoviesSimplDTO> result = moviesMapper.moviesModelListtoDTOSimplList(models);
        return result;
    }
    public MoviesDTO updateMovie(Long id, MoviesDTO dto){
        MoviesModel moviesModel=moviesRepository.getById(id);
        moviesModel.setTitle(dto.getTitle());
        moviesModel.setImage(dto.getImage());
        moviesModel.setCreationDate(dto.getCreationDate());
        moviesModel.setQuealification(dto.getQualification());
        moviesModel=moviesRepository.save(moviesModel);
        MoviesDTO results = moviesMapper.moviesModeltoDTO(moviesModel);
        return results;

    }
    public void deleteMovie(Long id){
        this.moviesRepository.deleteById(id);
    }
}
