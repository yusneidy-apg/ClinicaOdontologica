package com.clinicaodontologica.app.clinicaodontologica.test;

import com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao.OdontologoDaoImpH2;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Odontologo;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoService;
import org.junit.Test;

import java.sql.SQLException;

public class OdontologoDTOTest {

    @Test
    void instanciarOdontologoTest() throws SQLException, ClassNotFoundException {
        //Arrange
        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoImpH2());
        Odontologo odontologo = new Odontologo("yusneidy", "Polanco", "459873");
        // Act
        odontologoService.guardarOdontologo(odontologo);

        //Assert

        //assertNotNull(odontologo);

    }
}