package com.prueba.desarrollo.gaia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "TIPOHELADO")
public class TipoHelado {

    private Long idTipoHelado;
    private String nombre;
    private Sabor sabor;

    @TableGenerator(name = "TipoHelado_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "TipoHelado_Gen", initialValue = 1000, allocationSize = 1)
    @Id
    @Column(name = "IDTIPOHELADO")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TipoHelado_Gen")
    public Long getIdTipoHelado() {
        return idTipoHelado;
    }

    @Column(name = "NOMBRE", nullable = false, length = 255)
    public String getNombre() {
        return nombre;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSABOR", referencedColumnName = "IDSABOR")
    public Sabor getSabor() {
        return sabor;
    }

    public void setIdTipoHelado(Long idTipoHelado) {
        this.idTipoHelado = idTipoHelado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "TipoHelado [idTipoHelado=" + idTipoHelado + ", nombre=" + nombre + "]";
    }

}
