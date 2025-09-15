package com.ejemplo.peliculas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    // Obtener todas las películas
    public List<Pelicula> obtenerTodas() {
        return peliculaRepository.findAll();
    }

    // Obtener una película por ID
    public Optional<Pelicula> obtenerPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    // Guardar o actualizar película
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Eliminar película por ID
    public void eliminarPorId(Long id) {
        peliculaRepository.deleteById(id);
    }
}

