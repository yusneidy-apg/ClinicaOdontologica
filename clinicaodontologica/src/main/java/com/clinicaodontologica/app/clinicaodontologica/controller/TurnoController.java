package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.modelos.Turno;
import com.clinicaodontologica.app.clinicaodontologica.servicios.PacienteService;
import com.clinicaodontologica.app.clinicaodontologica.servicios.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }
    @RequestMapping
    public Turno crearTurno (@RequestBody Turno turno) throws SQLException, ClassNotFoundException {
        return turnoService.guardarTurno(turno);
    }

}
