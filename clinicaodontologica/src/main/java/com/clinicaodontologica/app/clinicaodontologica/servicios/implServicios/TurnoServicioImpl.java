package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.TurnoDTO;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.PacienteRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.TurnoRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.TurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServicioImpl implements TurnoServicio {

    private TurnoRepositorio turnoRepositorio;

    @Autowired
    public TurnoServicioImpl(TurnoRepositorio turnoRepositorio) {
        this.turnoRepositorio = turnoRepositorio;
    }

    @Override
    public TurnoDTO crear(TurnoDTO turnoDTO) {
        return null;
    }

    @Override
    public TurnoDTO modificar(TurnoDTO turnoDTO) {
        return null;
    }

    @Override
    public List<TurnoDTO> listar() {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
