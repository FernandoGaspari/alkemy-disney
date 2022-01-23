package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
public class MoviesFilterDTO {
    private String title;
    private Date creationDate;
    private Set<Long>genres;
    private String order;

    public MoviesFilterDTO(String title, Date creationDate, Set<Long> genres, String order) {
        this.title = title;
        this.creationDate = creationDate;
        this.genres = genres;
        this.order = order;
    }

    public boolean isASC(){
        return order.compareToIgnoreCase("ASC")==0;
    }

    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC")==0;
    }
    }
