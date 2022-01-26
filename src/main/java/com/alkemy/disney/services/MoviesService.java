package com.alkemy.disney.services;

import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.dto.MoviesDTO;
import com.alkemy.disney.dto.MoviesDetailsDTO;
import com.alkemy.disney.dto.MoviesSimplDTO;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface MoviesService {
    MoviesDTO addMovie(MoviesDTO movie);
    MoviesDetailsDTO getAllMovies(Long id);
    List<MoviesSimplDTO> getAllMoviesSimpl();
    void deleteMovie(Long id);

    MoviesDTO updateMovie(Long id, MoviesDTO movie);

    List<MoviesDTO> getByFilters(String title, Set<Long> genres, String order);
}
