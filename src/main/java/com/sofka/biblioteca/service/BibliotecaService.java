package com.sofka.biblioteca.service;

import com.sofka.biblioteca.domain.BibliotecaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BibliotecaService {

    Mono<BibliotecaDTO> save(BibliotecaDTO biblodto);

    Flux<BibliotecaDTO> findAll();

    Flux<BibliotecaDTO> findByTipoRecurso(String tipoRecurso);

    Flux<BibliotecaDTO> findByNombreRecurso(String nombreRecurso);

    Mono<String> findByDisponible(String id);

    Mono<BibliotecaDTO> prestar(String id, BibliotecaDTO biblioteca);

    Mono<BibliotecaDTO> devolver(String id, BibliotecaDTO biblioteca);
}
