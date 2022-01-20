package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharactersDTO {
    private Long id;
    private String name;
    private String image;
    private Short age;
    private Float weight;
    private String history;
}