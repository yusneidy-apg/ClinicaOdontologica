package com.clinicaodontologica.app.clinicaodontologica.test;



import com.clinicaodontologica.app.clinicaodontologica.modelos.Turno;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


class TurnoTest {

    @Test
    void instanciarTurnoTest(){
        Turno turno1 = new Turno();
        assertNotNull(turno1);
    }

}