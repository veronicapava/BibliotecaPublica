package com.sofka.biblioteca;

import com.sofka.biblioteca.domain.BibliotecaDTO;
import com.sofka.biblioteca.service.impl.BibliotecaServiceimpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class BibliotecaApplicationTests {

	@Autowired
	BibliotecaServiceimpl bibloservice;
	@Test
	void contextLoads() {
	}

	//Test de postear en la biblioteca
	@Test
	void testpostBiblo() {
		BibliotecaDTO biblioteca = new BibliotecaDTO();
		biblioteca.setId("123456");
		biblioteca.setNombreRecurso("Cenicienta");
		biblioteca.setDisponible(true);
		biblioteca.setTipoRecurso("Libro");
		biblioteca.setFechaPrestamo("0000-00-00");

		Mono<BibliotecaDTO> testpostBiblo = bibloservice.save(biblioteca);
		StepVerifier.create(testpostBiblo).expectNext(biblioteca).verifyComplete();

	}

	//Test para obtener todos los recursos de la biblioteca

	@Test
	void testFluxBiblo() {
		Flux<BibliotecaDTO> testFluxBib = (Flux<BibliotecaDTO>) bibloservice.findAll();
		StepVerifier.create(testFluxBib).expectComplete();
	}

	//Test para conseguir recurso por nombre
	@Test
	void testFluxRecursoName() {
		Flux<BibliotecaDTO> testFluxRecurso = bibloservice.findByNombreRecurso("Cenicienta");
		StepVerifier.create(testFluxRecurso).expectComplete();
	}

	//Test para conseguir recurso por tipo de recurso
	@Test
	void testFluxRecursoType() {
		Flux<BibliotecaDTO> testFluxRecursotype = bibloservice.findByTipoRecurso("Libro");
		StepVerifier.create(testFluxRecursotype).expectComplete();
	}

	//Test para obtener recursos disponibles por id
	@Test
	void testMonoRecursoDisponible() {
		Mono<String> testMonoRecursoDisponible = bibloservice.findByDisponible("123456");
		StepVerifier.create(testMonoRecursoDisponible).expectComplete();
	}



}
