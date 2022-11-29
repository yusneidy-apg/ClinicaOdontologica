package com.clinicaodontologica.app.clinicaodontologica.test;

import com.clinicaodontologica.app.clinicaodontologica.entities.Usuario;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


class UsuarioTest {
    @Test
    void instanciarUsuarioTest(){
        Usuario usuario1 = new Usuario();
        assertNotNull(usuario1);
    }

}