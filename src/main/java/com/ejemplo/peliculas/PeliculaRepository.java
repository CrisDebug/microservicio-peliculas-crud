package com.ejemplo.peliculas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // Aquí puedes agregar consultas personalizadas si necesitas
}
