package com.clinicaodontologica.app.clinicaodontologica.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LanzarExcepcionesGeneral {
    @ExceptionHandler({NoEncontradoException.class})
    public ResponseEntity<String> procesoExcepcionBadRequest(NoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({RecursoCreadoException.class})
    public ResponseEntity<String> procesoExcepcionBadRequest(RecursoCreadoException e) {
        return ResponseEntity.status(HttpStatus.FOUND).body(e.getMessage());
    }
}
