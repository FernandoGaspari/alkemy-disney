package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.MoviesDetailsDTO;
import com.alkemy.disney.dto.MoviesSimplDTO;
import com.alkemy.disney.services.MoviesService;
import com.alkemy.disney.dto.MoviesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @GetMapping
    public ResponseEntity<List<MoviesSimplDTO>> getAllSimpl(){
        List<MoviesSimplDTO> movies = moviesService.getAllMoviesSimpl();
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MoviesDetailsDTO> getAll(@PathVariable Long id){
        MoviesDetailsDTO movies = moviesService.getAllMovies(id);
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<MoviesDTO>>getByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Set<Long> genres,
            @RequestParam(required = false, defaultValue = "ASC") String order){
        System.out.println(order);
        List<MoviesDTO> movies=moviesService.getByFilters(title, genres, order);

        return ResponseEntity.ok(movies);
    }
    @PostMapping()
    public ResponseEntity<MoviesDTO> addMovie(@RequestBody MoviesDTO movie){
        MoviesDTO addedMovie = moviesService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MoviesDTO>updateMovie(@PathVariable Long id, @RequestBody MoviesDTO movie){
        MoviesDTO updatedMovie=moviesService.updateMovie(id, movie);
        return ResponseEntity.ok().body(updatedMovie);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        this.moviesService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
