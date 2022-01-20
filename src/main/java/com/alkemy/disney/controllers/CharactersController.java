package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharactersController {
    @Autowired
    private CharactersService charactersService;
    
    @GetMapping
    public ResponseEntity<List<CharactersSimplDTO>> getAllSimpl(){
        List<CharactersSimplDTO> characters = charactersService.getAllCharactersSimpl();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("details")
    public ResponseEntity<List<CharactersDTO>> getAll(){
        List<CharactersDTO> characters = charactersService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @PostMapping
    public ResponseEntity<CharactersDTO> addCharacter(@RequestBody CharactersDTO character){
        CharactersDTO addedCharacter = charactersService.addCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCharacter);
    }

}
