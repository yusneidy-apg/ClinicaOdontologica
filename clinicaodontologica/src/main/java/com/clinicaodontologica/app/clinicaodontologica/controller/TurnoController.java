package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.dto.TurnoDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Turno;
import com.clinicaodontologica.app.clinicaodontologica.servicios.TurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    private final TurnoServicio turnoServicio;

    @Autowired
    public TurnoController(TurnoServicio turnoServicio) {
        this.turnoServicio = turnoServicio;
    }
    @RequestMapping
    public TurnoDTO crearTurno (@RequestBody TurnoDTO turnoDTO) throws SQLException, ClassNotFoundException {
        return turnoServicio.crear(turnoDTO);
    }

}
