    package com.ejemplo.peliculas;
    import com.ejemplo.peliculas.dto.PeliculaDTO;
    import com.ejemplo.peliculas.mapper.PeliculaMapper;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

    @RestController // Indica que esta clase maneja peticiones REST
    @RequestMapping("/peliculas") // Ruta base para todos los endpoints
    public class PeliculaController {

        private final PeliculaService peliculaService;

        // Constructor para inyectar el servicio
        public PeliculaController(PeliculaService peliculaService) {
            this.peliculaService = peliculaService;
        }

        // GET /peliculas - Obtener todas las películas
        @GetMapping
        public List<Pelicula> obtenerPeliculas() {
            return peliculaService.obtenerTodas();
        }

        // GET /peliculas/{id} - Obtener película por ID
        @GetMapping("/{id}")
        public ResponseEntity<Pelicula> obtenerPorId(@PathVariable Long id) {
            Optional<Pelicula> pelicula = peliculaService.obtenerPorId(id);
            return pelicula.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // POST /peliculas - Crear una nueva película
        @PostMapping        
        public ResponseEntity<Pelicula> crearPelicula(@Valid @RequestBody PeliculaDTO peliculaDTO) {
        Pelicula pelicula = PeliculaMapper.toEntity(peliculaDTO);
        Pelicula peliculaCreada = peliculaService.guardarPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaCreada);
        }


        // PUT /peliculas/{id} - Actualizar una película existente
        @PutMapping("/{id}")
        public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula peliculaActualizada) {
            Optional<Pelicula> peliculaExistente = peliculaService.obtenerPorId(id);

            if (peliculaExistente.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Pelicula pelicula = peliculaExistente.get();
            pelicula.setTitulo(peliculaActualizada.getTitulo());
            pelicula.setAnio(peliculaActualizada.getAnio());
            pelicula.setDirector(peliculaActualizada.getDirector());
            pelicula.setGenero(peliculaActualizada.getGenero());
            pelicula.setSinopsis(peliculaActualizada.getSinopsis());

            Pelicula peliculaGuardada = peliculaService.guardarPelicula(pelicula);
            return ResponseEntity.ok(peliculaGuardada);
        }

        // DELETE /peliculas/{id} - Eliminar una película por ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
            Optional<Pelicula> peliculaExistente = peliculaService.obtenerPorId(id);

            if (peliculaExistente.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            peliculaService.eliminarPorId(id);
            return ResponseEntity.noContent().build();
        }
    }



