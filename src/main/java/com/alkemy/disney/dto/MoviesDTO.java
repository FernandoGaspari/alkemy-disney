package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MoviesDTO {
    private Long id;
    private String title;
    private String image;
    private Date creationDate;
    private Short qualification;

}
