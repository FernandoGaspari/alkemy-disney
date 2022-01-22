package com.alkemy.disney.dto;

import com.alkemy.disney.models.MoviesModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharactersDTO {
    private Long id;
    private String name;
    private String image;
    private Short age;
    private Float weight;
    private String history;
    private Set<MoviesModel> movies;
}