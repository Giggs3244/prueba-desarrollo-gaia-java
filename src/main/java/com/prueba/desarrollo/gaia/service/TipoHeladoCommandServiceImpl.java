package com.prueba.desarrollo.gaia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.desarrollo.gaia.entity.Sabor;
import com.prueba.desarrollo.gaia.entity.TipoHelado;
import com.prueba.desarrollo.gaia.model.TipoHeladoRegisterDto;
import com.prueba.desarrollo.gaia.model.TipoHeladoUpdateDto;
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
    public void createTipoHelado(TipoHeladoRegisterDto tipoHeladoDto) {

        TipoHelado tipoHelado = new TipoHelado();

        tipoHelado.setNombre(tipoHeladoDto.getNombre());

        Sabor sabor = saborRepository.getOne(tipoHeladoDto.getIdSabor());
        logger.debug("Sabor del Tipo de Helado que se va a almacenar {}", sabor);

        tipoHelado.setSabor(sabor);

        logger.debug("Tipo de Helado que se va a almacenar {}", tipoHelado);
        tipoHeladoRepository.save(tipoHelado);
    }

    @Override
    public void updateTipoHelado(TipoHeladoUpdateDto tipoHeladoDto) {

        TipoHelado tipoHelado = tipoHeladoRepository.getOne(tipoHeladoDto.getIdTipoHelado());
        Sabor saborActual = tipoHelado.getSabor();

        if (saborActual.getIdSabor() != tipoHeladoDto.getIdSabor()) {
            logger.debug("Se actualiza el sabor del tipo de helado");
            Sabor sabor = saborRepository.getOne(tipoHeladoDto.getIdSabor());
            tipoHelado.setSabor(sabor);
        }

        tipoHelado.setNombre(tipoHeladoDto.getNombre());
        tipoHeladoRepository.save(tipoHelado);
    }

    @Override
    public void deleteTipoHelado(Long idTipoHelado) {

        tipoHeladoRepository.deleteById(idTipoHelado);

    }

}
