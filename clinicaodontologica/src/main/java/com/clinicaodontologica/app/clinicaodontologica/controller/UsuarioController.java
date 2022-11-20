package com.clinicaodontologica.app.clinicaodontologica.controller;


import com.clinicaodontologica.app.clinicaodontologica.modelos.Usuario;
import com.clinicaodontologica.app.clinicaodontologica.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario crearUsuario (@RequestBody Usuario usuario) throws SQLException, ClassNotFoundException {
        return usuarioService.guardarUsuario(usuario);
    }
}
