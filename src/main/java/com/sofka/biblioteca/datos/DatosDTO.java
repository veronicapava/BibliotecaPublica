package com.sofka.biblioteca.datos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection= "libreria")
public class DatosDTO {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private boolean disponible = true;
    private String fechaPrestamo;
    private String nombreLibro;
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

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
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
        return "DatosDTO{" +
                "id='" + id + '\'' +
                ", disponible=" + disponible +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", nombreLibro='" + nombreLibro + '\'' +
                ", tipoRecurso='" + tipoRecurso + '\'' +
                ", tematica='" + tematica + '\'' +
                '}';
    }
}
