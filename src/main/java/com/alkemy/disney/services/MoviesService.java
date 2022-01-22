package com.alkemy.disney.services;

import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.dto.MoviesDTO;
import com.alkemy.disney.dto.MoviesSimplDTO;

import java.util.List;

public interface MoviesService {
    MoviesDTO addMovie(MoviesDTO movie);
    List<MoviesDTO> getAllMovies();
    List<MoviesSimplDTO> getAllMoviesSimpl();
    void deleteMovie(Long id);

    MoviesDTO updateMovie(Long id, MoviesDTO movie);
}
