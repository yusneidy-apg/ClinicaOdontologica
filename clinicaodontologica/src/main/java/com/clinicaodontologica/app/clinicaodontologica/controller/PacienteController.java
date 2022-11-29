package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Paciente;
import com.clinicaodontologica.app.clinicaodontologica.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @Autowired
    public PacienteController(PacienteServicio pacienteServicio) {
        this.pacienteServicio = pacienteServicio;
    }
    @PostMapping
    public PacienteDTO crearPaciente (@RequestBody PacienteDTO pacienteDTO) throws SQLException, ClassNotFoundException {
      return pacienteServicio.crear(pacienteDTO);
    }
}
