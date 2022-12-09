package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
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
    @PostMapping
    public PacienteDTO crearPaciente (@RequestBody PacienteDTO pacienteDTO) throws NoEncontradoException {
        return pacienteServicio.crear(pacienteDTO);
    }
    @GetMapping
    public List<PacienteDTO> buscarTodosLosPacientes() {
        return pacienteServicio.listar();
    }

    @GetMapping("/{idPaciente}")
    public PacienteDTO buscarPacientePorId(@PathVariable Integer idPaciente) {
        return pacienteServicio.bucarPorId(idPaciente);
    }

    @GetMapping("/buscarPorUnicoIdPaciente/{idpaciente}")
    public PacienteDTO buscarPorUnicoIdPaciente(@PathVariable String dni) throws NoEncontradoException {
        return pacienteServicio.buscarPorUnicoDni(dni);
    }



    @PutMapping
    public PacienteDTO modificarOdontologo(@RequestBody PacienteDTO pacienteDTO) throws NoEncontradoException {
        return pacienteServicio.modificar(pacienteDTO);
    }

    @DeleteMapping("/eliminar/{idPaciente}")
    public void eliminarPaciente(@PathVariable Integer idPaciente) {
        pacienteServicio.eliminar(idPaciente);
    }
}

