package com.prueba.desarrollo.gaia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "SABOR")
public class Sabor {

    private Long idSabor;
    private String nombre;
    private TipoHelado tipoHelado;

    @TableGenerator(name = "Sabor_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Sabor_Gen", initialValue = 1000, allocationSize = 1)
    @Id
    @Column(name = "IDSABOR")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Sabor_Gen")
    public Long getIdSabor() {
        return idSabor;
    }

    @Column(name = "NOMBRE", nullable = false, length = 255)
    public String getNombre() {
        return nombre;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sabor")
    public TipoHelado getTipoHelado() {
        return tipoHelado;
    }

    public void setIdSabor(Long idSabor) {
        this.idSabor = idSabor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoHelado(TipoHelado tipoHelado) {
        this.tipoHelado = tipoHelado;
    }

    @Override
    public String toString() {
        return "Sabor [idSabor=" + idSabor + ", nombre=" + nombre + "]";
    }

}
