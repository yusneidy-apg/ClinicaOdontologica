package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;

import java.util.List;

public interface PacienteServicio {
    PacienteDTO crear(PacienteDTO pacienteDTO);
    PacienteDTO modificar(PacienteDTO pacienteDTO);
    List<PacienteDTO> listar();
    void eliminar(int id);
}
