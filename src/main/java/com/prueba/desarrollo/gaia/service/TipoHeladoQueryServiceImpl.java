package com.prueba.desarrollo.gaia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.desarrollo.gaia.model.TipoHeladoDto;
import com.prueba.desarrollo.gaia.repository.TipoHeladoRepository;

@Service
public class TipoHeladoQueryServiceImpl implements ITipoHeladoQueryService {

    private final TipoHeladoRepository tipoHeladoRepository;

    @Autowired
    public TipoHeladoQueryServiceImpl(TipoHeladoRepository tipoHeladoRepository) {
        this.tipoHeladoRepository = tipoHeladoRepository;
    }

    @Override
    public List<TipoHeladoDto> getTiposHeladoList() {

        return tipoHeladoRepository.getTiposHelado();

    }

}
