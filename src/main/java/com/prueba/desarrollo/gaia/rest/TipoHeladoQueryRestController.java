package com.prueba.desarrollo.gaia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.desarrollo.gaia.service.ITipoHeladoQueryService;

@RestController
@RequestMapping(value = "/tiposhelados")
public class TipoHeladoQueryRestController extends BaseController {

    private final ITipoHeladoQueryService tipoHeladoService;

    @Autowired
    public TipoHeladoQueryRestController(ITipoHeladoQueryService tipoHeladoService) {
        this.tipoHeladoService = tipoHeladoService;
    }

    @GetMapping
    public List<com.prueba.desarrollo.gaia.projection.TipoHelado> getUsersList() {

        return tipoHeladoService.getTiposHeladoList();

    }

}
