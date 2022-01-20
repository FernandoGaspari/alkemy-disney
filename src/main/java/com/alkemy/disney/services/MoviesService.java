package com.alkemy.disney.services;

import com.alkemy.disney.dto.MoviesDTO;

import java.util.List;

public interface MoviesService {
    MoviesDTO addMovie(MoviesDTO movie);
    List<MoviesDTO> getAllMovies();
}
