package com.prueba.desarrollo.gaia.rest;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.desarrollo.gaia.model.TipoHeladoRegisterDto;
import com.prueba.desarrollo.gaia.model.TipoHeladoUpdateDto;
import com.prueba.desarrollo.gaia.service.ITipoHeladoCommandService;

@RestController
@RequestMapping(value = "/tiposhelados")
public class TipoHeladoCommandRestController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(TipoHeladoCommandRestController.class);

    private final ITipoHeladoCommandService tipoHeladoService;

    @Autowired
    public TipoHeladoCommandRestController(ITipoHeladoCommandService tipoHeladoService) {
        this.tipoHeladoService = tipoHeladoService;
    }

    @PostMapping
    public void getUsersList(@Valid @RequestBody TipoHeladoRegisterDto tipoHeladoDto) {
        logger.debug("request TipoHeladoRegisterDto {}", tipoHeladoDto);

        tipoHeladoService.createTipoHelado(tipoHeladoDto);
    }

    @PutMapping
    public void updateTipoHelado(@Valid @RequestBody TipoHeladoUpdateDto tipoHeladoDto) {
        logger.debug("request TipoHeladoUpdateDto {}", tipoHeladoDto);

        tipoHeladoService.updateTipoHelado(tipoHeladoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoHelado(@PathParam(value = "id") Long idTipoHelado) {
        logger.debug("request idTipoHelado {}", idTipoHelado);

        tipoHeladoService.deleteTipoHelado(idTipoHelado);
    }

}
