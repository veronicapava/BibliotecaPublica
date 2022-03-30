package com.sofka.biblioteca.service;

import com.sofka.biblioteca.domain.BibliotecaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BibliotecaService {

    Mono<BibliotecaDTO> save(BibliotecaDTO biblodto);

    Flux<BibliotecaDTO> findAll();
}
