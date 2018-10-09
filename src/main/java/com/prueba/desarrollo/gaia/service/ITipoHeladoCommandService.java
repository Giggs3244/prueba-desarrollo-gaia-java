package com.prueba.desarrollo.gaia.service;

import com.prueba.desarrollo.gaia.model.TipoHeladoDto;

public interface ITipoHeladoCommandService {

    public void createTipoHelado(TipoHeladoDto tipoHelado);

    public void updateTipoHelado(Long idTipoHelado, TipoHeladoDto tipoHelado);

    public void deleteTipoHelado(Long idTipoHelado);

}
