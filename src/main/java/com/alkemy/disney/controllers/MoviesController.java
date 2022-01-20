package com.alkemy.disney.controllers;

import com.alkemy.disney.services.MoviesService;
import com.alkemy.disney.dto.MoviesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies/details")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @GetMapping
    public ResponseEntity<List<MoviesDTO>> getAll(){
        List<MoviesDTO> movies = moviesService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }
    @PostMapping
    public ResponseEntity<MoviesDTO> addMovie(@RequestBody MoviesDTO movie){
        MoviesDTO addedMovie = moviesService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
    }
}
