package com.alkemy.disney.dto;

import com.alkemy.disney.models.CharactersModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;
//import java.util.List;

@Getter
@Setter
public class MoviesDTO {
    private Long id;
    private String title;
    private String image;
    private Date creationDate;
    private Short qualification;
    private Set<CharactersModel> characters;

}
