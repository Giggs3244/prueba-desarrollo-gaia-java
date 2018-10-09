package com.prueba.desarrollo.gaia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.desarrollo.gaia.entity.TipoHelado;

@Repository
public interface TipoHeladoRepository extends JpaRepository<TipoHelado, Long> {

    @Query(value = "SELECT th.idTipoHelado AS idTipoHelado, th.nombre AS nombreTipoHelado, s.idSabor AS idSabor, s.nombre AS nombreSabor FROM TipoHelado th JOIN th.sabor s")
    public List<com.prueba.desarrollo.gaia.projection.TipoHelado> getTiposHelado();

}
