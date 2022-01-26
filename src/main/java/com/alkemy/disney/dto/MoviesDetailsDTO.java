package com.alkemy.disney.dto;

import com.alkemy.disney.models.CharactersModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
public class MoviesDetailsDTO {
    private Long id;
    private String title;
    private String image;
    private Date creationDate;
    private Short qualification;
    private Set<String> characters;
}
