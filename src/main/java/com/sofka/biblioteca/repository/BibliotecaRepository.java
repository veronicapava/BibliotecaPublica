package com.sofka.biblioteca.repository;

import com.sofka.biblioteca.domain.BibliotecaDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BibliotecaRepository extends ReactiveMongoRepository<BibliotecaDTO, String> {

    Flux<BibliotecaDTO> findByTipoRecurso(String tipoRecurso);

    Flux<BibliotecaDTO> findByNombreRecurso(String nombreRecurso);
/*
    Mono<String> findByDisponible(String id);*/

    /*Mono<BibliotecaDTO> isDisponible(String nombreRecurso, BibliotecaDTO biblodto);*/

   /* Mono<BibliotecaDTO> findResourceByAva(String nombreLibro);*/
}
