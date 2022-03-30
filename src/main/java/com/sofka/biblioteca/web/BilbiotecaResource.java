package com.sofka.biblioteca.web;

import com.sofka.biblioteca.BibliotecaApplication;
import com.sofka.biblioteca.domain.BibliotecaDTO;
import com.sofka.biblioteca.service.BibliotecaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class BilbiotecaResource {
    private static final Logger log = LoggerFactory.getLogger(BibliotecaApplication.class);


    @Autowired
    private BibliotecaService bibloservice;

    //Obtener los datos de la biblioteca
    @GetMapping(value = "/biblioteca")
    private Flux<BibliotecaDTO> findAll(){
        return this.bibloservice.findAll();
    }

    //Postear datos en la biblioteca
    @PostMapping("/biblioteca/post")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<BibliotecaDTO> save(@RequestBody BibliotecaDTO bibloDTO){
        return this.bibloservice.save(bibloDTO);
    }

    //Obtener por tipo de recurso
    @GetMapping(value ="/biblioteca/recursotipo/{tipo}")
    private Flux<BibliotecaDTO> findTipoDeRecurso(@PathVariable("tipo") String tipoRecurso){
        return this.bibloservice.findByTipoRecurso(tipoRecurso);
    }

    //Obtener recurso por nombre
    @GetMapping(value ="/biblioteca/recursonombre/{nombre}")
    private Flux<BibliotecaDTO> findPorNombreRecurso(@PathVariable("nombre") String nombreRecurso){
        return this.bibloservice.findByNombreRecurso(nombreRecurso);
    }

    //Obtener recursos disponibles por nombre
    @GetMapping(value= "/biblioteca/disponible/{id}")
    private Mono<String> disponibilidad(@PathVariable("id") String id){
        return this.bibloservice.findByDisponible(id);
    }

}
