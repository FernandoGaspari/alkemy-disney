package com.alkemy.disney.services;

import com.alkemy.disney.dto.MoviesDTO;
import com.alkemy.disney.dto.MoviesDetailsDTO;
import com.alkemy.disney.dto.MoviesSimplDTO;

import java.util.List;
import java.util.Set;

public interface MoviesService {
    MoviesDTO addMovie(MoviesDTO movie);
    MoviesDetailsDTO getAllMovies(Long id);
    List<MoviesSimplDTO> getAllMoviesSimpl();
    void deleteMovie(Long id);

    MoviesDTO updateMovie(Long id, MoviesDTO movie);

    List<MoviesDetailsDTO> getByFilters(String title, String order, Set<Long> genre);
}
