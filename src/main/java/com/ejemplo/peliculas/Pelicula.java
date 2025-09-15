package com.ejemplo.peliculas;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas") // Nombre de la tabla en tu base de datos
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula") // Asegúrate de que coincida con el nombre real en tu DB
    private Long id;

    private String titulo;

    @Column(name = "anio")
    private Integer anio;  // Cambiado de LocalDate a Integer

    private String director;
    private String genero;

    @Lob
    @Column(name = "sinopsis")
    private String sinopsis;

    // Constructor vacío requerido por JPA
    public Pelicula() {}

    // Constructor con todos los campos
    public Pelicula(Long id, String titulo, Integer anio, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
