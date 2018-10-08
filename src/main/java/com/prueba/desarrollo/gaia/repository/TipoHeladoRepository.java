package com.prueba.desarrollo.gaia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.desarrollo.gaia.entity.TipoHelado;
import com.prueba.desarrollo.gaia.model.TipoHeladoDto;

@Repository
public interface TipoHeladoRepository extends JpaRepository<TipoHelado, Long> {

    @Query(value = "SELECT new com.prueba.desarrollo.gaia.model.TipoHeladoDto(th.idTipoHelado, th.nombre, s.idSabor, s.nombre) FROM TipoHelado th JOIN th.sabor s")
    public List<TipoHeladoDto> getTiposHelado();

}
