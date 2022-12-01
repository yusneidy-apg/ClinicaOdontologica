package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.dto.TurnoDTO;

import java.util.List;

public interface TurnoServicio {

    TurnoDTO crear(TurnoDTO turnoDTO);
    TurnoDTO modificar(TurnoDTO turnoDTO);
    TurnoDTO buscarPorId(Integer idTurno);
    List<TurnoDTO> listar();
    void eliminar(int id);
    TurnoDTO buscarPorUnicoIdTurno(int idTurno);
}
