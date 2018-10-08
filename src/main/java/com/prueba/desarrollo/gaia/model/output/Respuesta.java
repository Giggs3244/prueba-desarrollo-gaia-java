package com.prueba.desarrollo.gaia.model.output;

import java.util.Date;

public class Respuesta {

    private int codigo;
    private String descripcion;
    private Date timestamp;
    private String detalleError;

    public String getDescripcion() {
        return descripcion;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetalleError() {
        return detalleError;
    }

    public void setDetalleError(String detalleError) {
        this.detalleError = detalleError;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Respuesta [codigo=" + codigo + ", descripcion=" + descripcion + ", timestamp=" + timestamp + ", detalleError="
                + detalleError + "]";
    }

}
