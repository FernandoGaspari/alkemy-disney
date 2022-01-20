package com.alkemy.disney.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genres")
@Getter
@Setter
public class GenresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String image;
    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private List<MoviesModel> movies = new ArrayList<>();
}
