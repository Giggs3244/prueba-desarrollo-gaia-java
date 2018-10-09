package com.prueba.desarrollo.gaia.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TipoHeladoDto {

    @NotBlank
    private String nombre;

    @NotNull
    private Long idSabor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(Long idSabor) {
        this.idSabor = idSabor;
    }

    @Override
    public String toString() {
        return "TipoHeladoDto [nombre=" + nombre + ", idSabor=" + idSabor + "]";
    }

}
