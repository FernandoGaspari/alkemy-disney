package com.alkemy.disney.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Movies")
@Getter
@Setter
public class MoviesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String title;
    private String image;
    @Column(name = "creation_date")
    private Date creationDate;
    private Short quealification;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE })
    @JoinTable(
            name = "character_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    Set<CharactersModel> characters = new HashSet<>();
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE })
    @JoinTable(
            name = "genre_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<GenresModel> genres = new HashSet<>();
}
