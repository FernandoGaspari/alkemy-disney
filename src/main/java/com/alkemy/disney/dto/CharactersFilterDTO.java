package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharactersFilterDTO {
    private String name;
    private Short age;
    private Set<Long>movies;

    public CharactersFilterDTO(String name, Short age, Set<Long> movies) {
        this.name = name;
        this.age = age;
        this.movies = movies;
    }
}
