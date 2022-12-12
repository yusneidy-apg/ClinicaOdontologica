package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.TurnoDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Turno;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.TurnoRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.TurnoServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoServicioImpl implements TurnoServicio {

    ObjectMapper mapper = new ObjectMapper();

    private final TurnoRepositorio turnoRepositorio;

    @Autowired
    public TurnoServicioImpl(TurnoRepositorio turnoRepositorio) {
        this.turnoRepositorio = turnoRepositorio;
    }

    @Override
    public TurnoDTO crear(TurnoDTO turnoDTO) {
        Turno turno = mapper.registerModule(new JavaTimeModule()).convertValue(turnoDTO, Turno.class);
        TurnoDTO turnoGuardado = buscarPorUnicoIdTurno(turnoDTO.getIdTurno());
        if(turnoGuardado !=null)
            turno.setIdTurno(turnoGuardado.getIdTurno());
        return mapper.convertValue(turnoRepositorio.save(turno), TurnoDTO.class);
    }

    @Override
    public TurnoDTO modificar(TurnoDTO turnoDTO) {
        return crear(turnoDTO);

    }
    @Override
    public TurnoDTO buscarPorId(Integer idTurno) {
        return mapper.registerModule(new JavaTimeModule()).convertValue(turnoRepositorio.findById(idTurno).orElse(new Turno()), TurnoDTO.class);
    }

    @Override
    public List<TurnoDTO> listar() {
        List<Turno> listaTurno = turnoRepositorio.findAll();
        List<TurnoDTO> listaRetorno = new ArrayList<>();
        listaTurno.forEach(turno -> {
            listaRetorno.add(mapper.convertValue(turno, TurnoDTO.class));
        });
        return listaRetorno;
    }

    @Override
    public void eliminar(int id) {
        turnoRepositorio.deleteById(id);

    }
    public TurnoDTO buscarPorUnicoIdTurno(int idTurno) {
        return mapper.convertValue(turnoRepositorio.findById(idTurno), TurnoDTO.class);
    }

}
