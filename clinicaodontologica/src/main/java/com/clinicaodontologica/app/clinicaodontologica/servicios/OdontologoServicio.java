package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;

import java.util.List;

public interface OdontologoServicio {
    OdontologoDTO crear(OdontologoDTO odontologoDTO);
    OdontologoDTO modificar(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarPorId(Integer idOdontologo);
    List<OdontologoDTO> listar();
    void eliminar(int id);
    OdontologoDTO buscarPorUnicaMarticula(String matricula);
}
