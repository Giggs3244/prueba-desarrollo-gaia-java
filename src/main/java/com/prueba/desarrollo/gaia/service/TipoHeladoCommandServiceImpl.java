package com.prueba.desarrollo.gaia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.desarrollo.gaia.entity.Sabor;
import com.prueba.desarrollo.gaia.entity.TipoHelado;
import com.prueba.desarrollo.gaia.model.TipoHeladoDto;
import com.prueba.desarrollo.gaia.repository.SaborRepository;
import com.prueba.desarrollo.gaia.repository.TipoHeladoRepository;

@Service
public class TipoHeladoCommandServiceImpl implements ITipoHeladoCommandService {

    private final Logger logger = LoggerFactory.getLogger(TipoHeladoCommandServiceImpl.class);

    private final TipoHeladoRepository tipoHeladoRepository;
    private final SaborRepository saborRepository;

    @Autowired
    public TipoHeladoCommandServiceImpl(TipoHeladoRepository tipoHeladoRepository, SaborRepository saborRepository) {
        this.tipoHeladoRepository = tipoHeladoRepository;
        this.saborRepository = saborRepository;
    }

    @Override
    public void createTipoHelado(TipoHeladoDto tipoHeladoDto) {
        TipoHelado tipoHelado = new TipoHelado();

        tipoHelado.setNombre(tipoHeladoDto.getNombre());

        Sabor sabor = saborRepository.getOne(tipoHeladoDto.getIdSabor());
        logger.debug("Sabor del Tipo de Helado que se va a almacenar {}", sabor);

        tipoHelado.setSabor(sabor);

        logger.debug("Tipo de Helado que se va a almacenar {}", tipoHelado);
        tipoHeladoRepository.save(tipoHelado);
    }

}
