package com.clinicaodontologica.app.clinicaodontologica.test;


import com.clinicaodontologica.app.clinicaodontologica.modelos.Paciente;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


class PacienteTest {

    @Test
    void instanciarPacienteTest(){
        Paciente paciente = new Paciente();
        assertNotNull(paciente);
    }

}