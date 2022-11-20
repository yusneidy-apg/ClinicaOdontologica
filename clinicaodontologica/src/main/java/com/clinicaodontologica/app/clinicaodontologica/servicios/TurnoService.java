package com.clinicaodontologica.app.clinicaodontologica.servicios;


import com.clinicaodontologica.app.clinicaodontologica.dao.CrutBd;
import com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao.TurnoDaoImpH2;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurnoService {

    private final CrutBd<Turno> turno;
    @Autowired
    public TurnoService(TurnoDaoImpH2 turnoDaoImpH2) {
        this.turno = turnoDaoImpH2;
    }

    public Turno guardarTurno(Turno turno) throws SQLException, ClassNotFoundException {
        return this.turno.crear(turno);
    }

    public List<Turno> listarTodosTurnos(){
        return turno.listar();
    }


    public void modificarTurno(Turno turno){
        this.turno.modificar(turno);
    }

    public void eliminarTurno(int id){
        turno.eliminar(id);
    }
}
