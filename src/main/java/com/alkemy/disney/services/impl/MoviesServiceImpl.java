package com.alkemy.disney.services.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.repositories.MoviesRepository;
import com.alkemy.disney.repositories.specifications.MovieSpecification;
import com.alkemy.disney.services.MoviesService;
import com.alkemy.disney.mapper.MoviesMapper;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesMapper moviesMapper;
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private MovieSpecification movieSpecification;
    public MoviesDTO addMovie(MoviesDTO dto){
        MoviesModel moviesModel = moviesMapper.movieDTOtoModel(dto);
        MoviesModel addedMovieModel = moviesRepository.save(moviesModel);
        MoviesDTO result = moviesMapper.moviesModeltoDTO(addedMovieModel);
        return result;
    }

    public MoviesDTO getAllMovies(Long id) {
        MoviesModel models = moviesRepository.getById(id);
        MoviesDTO result = moviesMapper.moviesModeltoDTO(models);
        return result;
    }
    public List<MoviesSimplDTO> getAllMoviesSimpl() {
        List<MoviesModel> models = moviesRepository.findAll();
        List<MoviesSimplDTO> result = moviesMapper.moviesModelListtoDTOSimplList(models);
        return result;
    }
    public List<MoviesDTO>getByFilters(String title, Date creationDate, Set<Long> genres, String order){
        MoviesFilterDTO moviesFilterDTO = new MoviesFilterDTO(title, creationDate, genres, order);
        List<MoviesModel> moviesModels = moviesRepository.findAll(movieSpecification.getByFilters(moviesFilterDTO));
        List<MoviesDTO>dtos=moviesMapper.movieModelSettoMovieDTOList(moviesModels);
        return dtos;
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
