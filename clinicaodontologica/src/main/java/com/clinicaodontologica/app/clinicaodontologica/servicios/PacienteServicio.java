package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;

import java.util.List;

public interface PacienteServicio {
    PacienteDTO crear(PacienteDTO pacienteDTO);
    PacienteDTO modificar(PacienteDTO pacienteDTO);
    PacienteDTO bucarPorId(Integer idPaciente);
    List<PacienteDTO> listar();
    void eliminar(int id);
    PacienteDTO buscarPorUnicoIdPaciente(int idPaciente);

}
