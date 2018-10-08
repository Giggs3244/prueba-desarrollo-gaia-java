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

@Entity
@Table(name = "TIPOHELADO")
public class TipoHelado {

    private Long idTipoHelado;
    private String nombre;
    private Sabor sabor;

    @Id
    @Column(name = "IDTIPOHELADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
