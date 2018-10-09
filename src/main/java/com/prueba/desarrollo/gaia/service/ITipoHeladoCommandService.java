package com.prueba.desarrollo.gaia.service;

import com.prueba.desarrollo.gaia.model.TipoHeladoRegisterDto;
import com.prueba.desarrollo.gaia.model.TipoHeladoUpdateDto;

public interface ITipoHeladoCommandService {

    public void createTipoHelado(TipoHeladoRegisterDto tipoHelado);

    public void updateTipoHelado(TipoHeladoUpdateDto tipoHelado);

    public void deleteTipoHelado(Long idTipoHelado);

}
