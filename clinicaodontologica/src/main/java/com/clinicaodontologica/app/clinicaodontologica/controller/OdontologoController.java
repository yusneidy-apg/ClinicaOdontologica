package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.modelos.Odontologo;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping ("/odontologo")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public Odontologo crearOdontologo (@RequestBody Odontologo odontologo) throws SQLException, ClassNotFoundException {
        return odontologoService.guardarOdontologo(odontologo);
    }
}
