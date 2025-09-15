package com.ejemplo.peliculas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//clase
public class PeliculaDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotNull(message = "El año es obligatorio")
    private Integer anio;

    @NotBlank(message = "El director es obligatorio")
    private String director;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @NotBlank(message = "La sinopsis es obligatoria")
    private String sinopsis;

    // Getters y setters

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

