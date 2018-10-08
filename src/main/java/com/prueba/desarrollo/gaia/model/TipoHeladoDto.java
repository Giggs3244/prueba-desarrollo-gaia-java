package com.prueba.desarrollo.gaia.model;

public class TipoHeladoDto {

    private Long idTipoHelado;
    private String nombre;
    private SaborDto sabor;

    public TipoHeladoDto() {
        super();
    }

    public TipoHeladoDto(Long idTipoHelado, String nombre, Long idSabor, String nombreSabor) {
        super();
        this.idTipoHelado = idTipoHelado;
        this.nombre = nombre;
        this.sabor = new SaborDto(idSabor, nombreSabor);
    }

    public Long getIdTipoHelado() {
        return idTipoHelado;
    }

    public String getNombre() {
        return nombre;
    }

    public SaborDto getSabor() {
        return sabor;
    }

    public void setIdTipoHelado(Long idTipoHelado) {
        this.idTipoHelado = idTipoHelado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSabor(SaborDto sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "TipoHeladoDto [idTipoHelado=" + idTipoHelado + ", nombre=" + nombre + ", sabor=" + sabor + "]";
    }

}
