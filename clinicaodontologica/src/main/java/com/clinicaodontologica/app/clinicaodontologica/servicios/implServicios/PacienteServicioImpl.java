package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.PacienteDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Paciente;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.PacienteRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.PacienteServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PacienteServicioImpl implements PacienteServicio {

    ObjectMapper mapper = new ObjectMapper();

    private final PacienteRepositorio pacienteRepositorio;

    @Autowired
    public PacienteServicioImpl(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }


    @Override
    public PacienteDTO crear(PacienteDTO pacienteDTO) throws NoEncontradoException {
        Paciente paciente = mapper.registerModule(new JavaTimeModule()).convertValue(pacienteDTO, Paciente.class);
        PacienteDTO pacienteGuardado = buscarPorUnicoDni(pacienteDTO.getDni());
        if(pacienteGuardado != null)
            paciente.setIdPaciente(pacienteGuardado.getIdPaciente());
        return mapper.convertValue(pacienteRepositorio.save(paciente), PacienteDTO.class);
    }


    @Override
    public PacienteDTO modificar(PacienteDTO pacienteDTO) throws NoEncontradoException {
        return crear(pacienteDTO);
    }

    @Override
    public PacienteDTO bucarPorId(Integer idPaciente){
        return mapper.convertValue(pacienteRepositorio.findById(idPaciente).orElse(new Paciente()), PacienteDTO.class);
    }


    @Override
    public List<PacienteDTO> listar() {
        List<Paciente> listaPaciente = pacienteRepositorio.findAll();
        List<PacienteDTO> listaRetorno = new ArrayList<>();
        listaPaciente.forEach(paciente -> {
            listaRetorno.add(mapper.convertValue(paciente, PacienteDTO.class));
        });
        return listaRetorno;
    }

    @Override
    public void eliminar(int id) {
        pacienteRepositorio.deleteById(id);
    }

    @Override
    public PacienteDTO buscarPorUnicoDni(String dni) throws NoEncontradoException {
        Paciente pacienteGuardado = pacienteRepositorio.findByDni(dni);
        if(pacienteGuardado == null){
            throw new NoEncontradoException("El paciente con el dni" + dni +  " no fue encontrado en la base de datos");
        }
        return mapper.convertValue(pacienteGuardado, PacienteDTO.class);
    }
}
