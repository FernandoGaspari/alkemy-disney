package com.alkemy.disney.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Characters")
@Getter
@Setter
public class CharactersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String image;
    private Short age;
    private Float weight;
    private String history;
    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private Set<MoviesModel> movies = new HashSet<MoviesModel>();
}
