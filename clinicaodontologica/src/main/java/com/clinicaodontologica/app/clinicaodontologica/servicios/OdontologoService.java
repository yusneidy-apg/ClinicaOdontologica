package com.clinicaodontologica.app.clinicaodontologica.servicios;


import com.clinicaodontologica.app.clinicaodontologica.dao.CrutBd;
import com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao.OdontologoDaoImpH2;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OdontologoService {

    private final CrutBd<Odontologo> odontologo;

    @Autowired
    public OdontologoService(OdontologoDaoImpH2 odontologoDaoImpH2) {
        this.odontologo = odontologoDaoImpH2;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        return this.odontologo.crear(odontologo);
    }

    public List<Odontologo> listarTodosOdontologos(){
        return odontologo.listar();
    }


    public void modificarOdontologo(Odontologo odontologo){
        this.odontologo.modificar(odontologo);
    }

    public void eliminarOdontologo(int id){
        odontologo.eliminar(id);
    }
}
