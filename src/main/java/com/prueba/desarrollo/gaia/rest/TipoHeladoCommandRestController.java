package com.prueba.desarrollo.gaia.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.desarrollo.gaia.model.TipoHeladoDto;
import com.prueba.desarrollo.gaia.service.ITipoHeladoCommandService;

@RestController
public class TipoHeladoCommandRestController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(TipoHeladoCommandRestController.class);

    private final ITipoHeladoCommandService tipoHeladoService;

    @Autowired
    public TipoHeladoCommandRestController(ITipoHeladoCommandService tipoHeladoService) {
        this.tipoHeladoService = tipoHeladoService;
    }

    @PostMapping("/tiposhelados")
    public void getUsersList(@Valid @RequestBody TipoHeladoDto tipoHeladoDto) {
        logger.debug("request TipoHeladoDto {}", tipoHeladoDto);

        tipoHeladoService.createTipoHelado(tipoHeladoDto);
    }

    @PutMapping("/tiposhelados/{id}")
    public void updateTipoHelado(@Valid @RequestBody TipoHeladoDto tipoHeladoDto,
            @PathVariable(value = "id", required = true) Long idTipoHelado) {
        logger.debug("request TipoHeladoDto {} - idTipoHelado {}", tipoHeladoDto, idTipoHelado);

        tipoHeladoService.updateTipoHelado(idTipoHelado, tipoHeladoDto);
    }

    @DeleteMapping("/tiposhelados/{id}")
    public void deleteTipoHelado(@PathVariable(value = "id", required = true) Long idTipoHelado) {
        logger.debug("request idTipoHelado {}", idTipoHelado);

        tipoHeladoService.deleteTipoHelado(idTipoHelado);
    }

}
