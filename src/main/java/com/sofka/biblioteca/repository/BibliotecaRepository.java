package com.sofka.biblioteca.repository;

import com.sofka.biblioteca.domain.BibliotecaDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BibliotecaRepository extends ReactiveMongoRepository<BibliotecaDTO, String> {
}
