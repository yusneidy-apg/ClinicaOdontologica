package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;
import com.clinicaodontologica.app.clinicaodontologica.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteServicio pacienteServicio;

    @Autowired
    public PacienteController(PacienteServicio pacienteServicio) {
        this.pacienteServicio = pacienteServicio;
    }

    @GetMapping
    public List<PacienteDTO> buscarTodosLosPacientes() {
        return pacienteServicio.listar();
    }

    @GetMapping("/{idPaciente}")
    public PacienteDTO buscarPacientePorId(@PathVariable Integer idPaciente) {
        return pacienteServicio.bucarPorId(idPaciente);
    }

    @GetMapping("/buscarPorIdPaciente/{idpaciente}")
    public PacienteDTO buscarPacientePorIdPaciente(@PathVariable Integer idPaciente){ // podria buscarlo por DNI?
        return pacienteServicio.bucarPorId(idPaciente);
    }


    @PostMapping
    public PacienteDTO crearPaciente (@RequestBody PacienteDTO pacienteDTO) throws SQLException, ClassNotFoundException {
      return pacienteServicio.crear(pacienteDTO);
    }
}
