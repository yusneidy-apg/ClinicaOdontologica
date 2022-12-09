package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Odontologo;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.OdontologoRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoServicioImpl implements OdontologoServicio {
    ObjectMapper mapper = new ObjectMapper();
    private final OdontologoRepositorio odontologoRepositorio;

    @Autowired
    public OdontologoServicioImpl(OdontologoRepositorio odontologoRepositorio) {
        this.odontologoRepositorio = odontologoRepositorio;
    }

    @Override
    public OdontologoDTO crear(OdontologoDTO odontologoDTO) throws NoEncontradoException {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        OdontologoDTO odontologoGuardado = buscarPorUnicaMarticula(odontologoDTO.getMatricula());
        if (odontologoGuardado != null)
            odontologo.setIdOdontologo(odontologoGuardado.getIdOdontologo());
        return mapper.convertValue(odontologoRepositorio.save(odontologo), OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO modificar(OdontologoDTO odontologoDTO) throws NoEncontradoException {
        return crear(odontologoDTO);
    }

    @Override
    public OdontologoDTO buscarPorId(Integer idOdontologo) {
        return mapper.convertValue(odontologoRepositorio.findById(idOdontologo).orElse(new Odontologo()), OdontologoDTO.class);
    }

    @Override
    public List<OdontologoDTO> listar() {
        List<Odontologo> listaOdontologo = odontologoRepositorio.findAll();
        List<OdontologoDTO> listaRetorno = new ArrayList<>();
        listaOdontologo.forEach(odont -> {
            listaRetorno.add(mapper.convertValue(odont, OdontologoDTO.class));
        });
        return listaRetorno;
    }

    @Override
    public void eliminar(int id) {
        odontologoRepositorio.deleteById(id);
    }

    @Override
    public OdontologoDTO buscarPorUnicaMarticula(String matricula) throws NoEncontradoException {
        Odontologo odontologoGuardado = odontologoRepositorio.findByMatricula(matricula);
        if (odontologoGuardado == null) {
            throw new NoEncontradoException("El Odontólogo con la matricula" + matricula + " no fue encontrado en la base de datos");
        }
        return mapper.convertValue(odontologoGuardado, OdontologoDTO.class);
    }
}
