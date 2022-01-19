package com.alkemy.disney.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Personajes")
@Getter
@Setter
public class PersonajesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String imagen;
    private Short edad;
    private Short peso;
    private String historia;
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculasModel> peliculas = new ArrayList<>();
}
