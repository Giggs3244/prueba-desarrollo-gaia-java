package com.prueba.desarrollo.gaia.model;

import javax.validation.constraints.NotNull;

public class TipoHeladoUpdateDto extends TipoHeladoRegisterDto {

    @NotNull
    private Long idTipoHelado;

    public Long getIdTipoHelado() {
        return idTipoHelado;
    }

    public void setIdTipoHelado(Long idTipoHelado) {
        this.idTipoHelado = idTipoHelado;
    }

    @Override
    public String toString() {
        return "TipoHeladoUpdateDto [idTipoHelado=" + idTipoHelado + ", toString()=" + super.toString() + "]";
    }

}
