package com.clinicaodontologica.app.clinicaodontologica.servicios;


import com.clinicaodontologica.app.clinicaodontologica.dao.CrutBd;
import com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao.PacienteDaoImplH2;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PacienteService {

    private final CrutBd<Paciente> paciente;

    @Autowired
    public PacienteService(PacienteDaoImplH2 pacienteDaoImplH2) {
        this.paciente = pacienteDaoImplH2;
    }

    public Paciente guardarPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        return this.paciente.crear(paciente);
    }

    public List<Paciente> listarTodosPaciente(){
        return paciente.listar();
    }


    public void modificarPaciente(Paciente paciente){
        this.paciente.modificar(paciente);
    }

    public void eliminarPaciente(int id){
        paciente.eliminar(id);
    }
}
