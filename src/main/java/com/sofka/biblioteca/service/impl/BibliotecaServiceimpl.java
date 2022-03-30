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

    @Override
    public Flux<BibliotecaDTO> findByNombreRecurso(String nombreRecurso) {
        return this.biblorepository.findByNombreRecurso(nombreRecurso);
    }

    @Override
    public Mono<String> findByDisponible(String id) {
        return this.biblorepository.findById(id).map(r -> r.isDisponible() ?
                "El recurso está disponible" :
                "El recurso no esta disponible, fue prestado el: " + r.getFechaPrestamo());
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
