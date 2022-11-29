package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;

import java.util.List;

public interface OdontologoServicio {
    OdontologoDTO crear(OdontologoDTO odontologoDTO);
    OdontologoDTO modificar(OdontologoDTO odontologoDTO);
    List<OdontologoDTO> listar();
    void eliminar(int id);
}
