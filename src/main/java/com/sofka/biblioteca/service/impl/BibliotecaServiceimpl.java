package com.sofka.biblioteca.service.impl;

import com.sofka.biblioteca.domain.BibliotecaDTO;
import com.sofka.biblioteca.repository.BibliotecaRepository;
import com.sofka.biblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BibliotecaServiceimpl implements BibliotecaService {

    @Autowired
    private BibliotecaRepository biblorepository;

    @Override
    public Mono<BibliotecaDTO> save(BibliotecaDTO biblodto) {
        return this.biblorepository.save(biblodto);
    }

    @Override
    public Flux<BibliotecaDTO> findAll() {
        return this.biblorepository.findAll();
    }

    @Override
    public Flux<BibliotecaDTO> findByTipoRecurso(String tipoRecurso) {
        return this.biblorepository.findByTipoRecurso(tipoRecurso);
    }

   /* //Encontrar recurso y mirar si esta disponible
    @Override
    public Mono<BibliotecaDTO> findResourceByAva(String nombreLibro) {
        return this.biblorepository.findResourceByAva(nombreLibro)
                .flatMap(biblo -> {
                    BibliotecaDTO.isDisponible() ? "El recurso está disponible" : "El recurso no esta disponible"
                }).switchIfEmpty(Mono.empty());
    }*/
}
