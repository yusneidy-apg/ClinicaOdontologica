package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Odontologo;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoServicio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios.OdontologoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/odontologo")
public class OdontologoController {


    private final OdontologoServicio odontologoServicio;

    @Autowired
    public OdontologoController(OdontologoServicioImpl odontologoServicioImpl) {
        this.odontologoServicio = odontologoServicioImpl;
    }

     @PostMapping
    public OdontologoDTO crearOdontologo (@RequestBody OdontologoDTO odontologoDTO) throws SQLException, ClassNotFoundException {
        return odontologoServicio.crear(odontologoDTO);
    }


}
