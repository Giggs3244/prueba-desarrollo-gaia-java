package com.prueba.desarrollo.gaia.model;

public class SaborDto {

    private Long idSabor;
    private String nombre;

    public SaborDto() {
        super();
    }

    public SaborDto(Long idSabor, String nombre) {
        super();
        this.idSabor = idSabor;
        this.nombre = nombre;
    }

    public Long getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(Long idSabor) {
        this.idSabor = idSabor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "SaborDto [idSabor=" + idSabor + ", nombre=" + nombre + "]";
    }

}
