package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.RecursoCreadoException;
import com.clinicaodontologica.app.clinicaodontologica.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public UsuarioDTO crearUsuario (@RequestBody UsuarioDTO usuarioDTO) throws RecursoCreadoException {
        return usuarioServicio.crear(usuarioDTO);
    }
    @GetMapping
    public List<UsuarioDTO> buscarTodosLosUsuarios() {
        return usuarioServicio.listar();
    }

    @GetMapping("/{idUsuario}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Integer idUsuario) throws NoEncontradoException {
        return usuarioServicio.buscarPorId(idUsuario);
    }

    @GetMapping("/buscarPorUsuario/{usuario}")
    public UsuarioDTO buscarPorUsuario(@PathVariable String usuario)  {
        return usuarioServicio.buscarPorUnicoUsuario(usuario);
    }

    @PutMapping
    public UsuarioDTO modificarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws NoEncontradoException {
        return usuarioServicio.modificar(usuarioDTO);
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public void eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioServicio.eliminar(idUsuario);
    }
}
