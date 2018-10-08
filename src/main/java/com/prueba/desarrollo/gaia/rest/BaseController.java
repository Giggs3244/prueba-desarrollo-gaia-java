package com.prueba.desarrollo.gaia.rest;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.desarrollo.gaia.model.output.Respuesta;

@RequestMapping(value = "/api/v1")
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * Captura una excepcion no controlada en la invocacion de un servicio, y asi retornar un respuesta mas amigable.
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<Respuesta> resolverRestException(Exception e) {
        logger.error("Se presento un error general y fue capturado por el @ExceptionHandler", e);

        Respuesta respuesta = new Respuesta();

        if (e instanceof MethodArgumentNotValidException || e instanceof MissingServletRequestParameterException) {
            respuesta.setCodigo(HttpStatus.BAD_REQUEST.value());
            respuesta.setDescripcion("Revisar los parametros que se enviaron en la peticion");
        } else {
            respuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
            respuesta.setDescripcion(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        respuesta.setDetalleError(e.getMessage());
        respuesta.setTimestamp(new Date());
        return new ResponseEntity<>(respuesta, HttpStatus.valueOf(respuesta.getCodigo()));
    }

}
