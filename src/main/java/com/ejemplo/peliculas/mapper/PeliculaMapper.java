package com.ejemplo.peliculas.mapper;

import com.ejemplo.peliculas.Pelicula;
import com.ejemplo.peliculas.dto.PeliculaDTO;


public class PeliculaMapper {

    // Convierte un DTO a una entidad
    public static Pelicula toEntity(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setAnio(dto.getAnio());
        pelicula.setDirector(dto.getDirector());
        pelicula.setGenero(dto.getGenero());
        pelicula.setSinopsis(dto.getSinopsis());
        return pelicula;
    }

    // Convierte una entidad a un DTO (opcional, si lo necesitas más adelante)
    public static PeliculaDTO toDTO(Pelicula pelicula) {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setTitulo(pelicula.getTitulo());
        dto.setAnio(pelicula.getAnio());
        dto.setDirector(pelicula.getDirector());
        dto.setGenero(pelicula.getGenero());
        dto.setSinopsis(pelicula.getSinopsis());
        return dto;
    }
}

    

