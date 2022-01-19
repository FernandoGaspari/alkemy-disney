package com.alkemy.disney.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Generos")
@Getter
@Setter
public class GenerosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String imagen;
    @ManyToMany(mappedBy = "generos", cascade = CascadeType.ALL)
    private List<PeliculasModel> peliculas = new ArrayList<>();
}
