package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.OdontologoRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServicioImpl implements OdontologoServicio {

    private final OdontologoRepositorio odontologoRepositorio;

    @Autowired
    public OdontologoServicioImpl(OdontologoRepositorio odontologoRepositorio) {
        this.odontologoRepositorio = odontologoRepositorio;
    }

    @Override
    public OdontologoDTO crear(OdontologoDTO odontologoDTO) {
        return null;
    }

    @Override
    public OdontologoDTO modificar(OdontologoDTO odontologoDTO) {
        return null;
    }

    @Override
    public List<OdontologoDTO> listar() {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
