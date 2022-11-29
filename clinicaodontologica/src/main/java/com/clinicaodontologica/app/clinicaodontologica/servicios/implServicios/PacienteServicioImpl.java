package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.PacienteRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicioImpl implements PacienteServicio {
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    public PacienteServicioImpl(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }


    @Override
    public PacienteDTO crear(PacienteDTO pacienteDTO) {
        return null;
    }

    @Override
    public PacienteDTO modificar(PacienteDTO pacienteDTO) {
        return null;
    }

    @Override
    public List<PacienteDTO> listar() {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
