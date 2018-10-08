package com.prueba.desarrollo.gaia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.desarrollo.gaia.model.TipoHeladoDto;
import com.prueba.desarrollo.gaia.service.ITipoHeladoQueryService;

@RestController
public class TipoHeladoQueryRestController extends BaseController {

    private final ITipoHeladoQueryService tipoHeladoService;

    @Autowired
    public TipoHeladoQueryRestController(ITipoHeladoQueryService tipoHeladoService) {
        this.tipoHeladoService = tipoHeladoService;
    }

    @GetMapping("/tiposhelado")
    public List<TipoHeladoDto> getUsersList() {

        return tipoHeladoService.getTiposHeladoList();

    }

}
