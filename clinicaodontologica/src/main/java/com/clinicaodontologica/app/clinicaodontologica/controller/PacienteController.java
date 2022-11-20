package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.modelos.Paciente;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoService;
import com.clinicaodontologica.app.clinicaodontologica.servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @PostMapping
    public Paciente crearPaciente (@RequestBody Paciente paciente) throws SQLException, ClassNotFoundException {
      return pacienteService.guardarPaciente(paciente);
    }
}
