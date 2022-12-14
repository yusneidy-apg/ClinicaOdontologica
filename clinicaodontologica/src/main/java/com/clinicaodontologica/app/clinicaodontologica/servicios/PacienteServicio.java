package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;

import java.util.List;

public interface PacienteServicio {
    PacienteDTO crear(PacienteDTO pacienteDTO);
    PacienteDTO modificar(PacienteDTO pacienteDTO);
    PacienteDTO bucarPorId(Integer idPaciente) throws NoEncontradoException;
    List<PacienteDTO> listar();
    void eliminar(int id);
    PacienteDTO buscarPorUnicoDni(String dni);

}
