package com.sofka.biblioteca.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection= "libreria")
public class BibliotecaDTO {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private boolean disponible = true;
    private String fechaPrestamo;
    private String nombreRecurso;
    private String tipoRecurso;
    private String tematica;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "BibliotecaDTO{" +
                "id='" + id + '\'' +
                ", disponible=" + disponible +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", nombreLibro='" + nombreRecurso + '\'' +
                ", tipoRecurso='" + tipoRecurso + '\'' +
                ", tematica='" + tematica + '\'' +
                '}';
    }
}
