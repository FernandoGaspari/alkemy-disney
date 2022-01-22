package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MoviesSimplDTO {
    private String image;
    private String title;
    private Date creationDate;
}
