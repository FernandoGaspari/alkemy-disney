package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.GenresDTO;
import com.alkemy.disney.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres/details")
public class GenresController {
    @Autowired
    private GenresService genresService;
    @GetMapping
    public ResponseEntity<List<GenresDTO>> getAll(){
        List<GenresDTO> genres = genresService.getAllGenres();
        return ResponseEntity.ok().body(genres);
    }
    @PostMapping
    public ResponseEntity<GenresDTO> addCharacter(@RequestBody GenresDTO genre){
        GenresDTO addedGenre = genresService.addGenre(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedGenre);
    }
}
