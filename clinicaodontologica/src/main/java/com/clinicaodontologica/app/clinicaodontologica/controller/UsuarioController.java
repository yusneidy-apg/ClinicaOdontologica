package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public UsuarioDTO crearUsuario (@RequestBody UsuarioDTO usuarioDTO) throws SQLException, ClassNotFoundException {
        return usuarioServicio.crear(usuarioDTO);
    }
    @GetMapping
    public List<UsuarioDTO> buscarTodosLosUsuarios() {
        return usuarioServicio.listar();
    }

    @GetMapping("/{idUsuario}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Integer idUsuario) {
        return usuarioServicio.buscarPorId(idUsuario);
    }

    @GetMapping("/buscarPorUnicoIdUsuario/{idUsuario}")
    public UsuarioDTO buscarPorUnicoIdUsuario(@PathVariable Integer idUsuario){ // podria buscarlo por DNI?
        return usuarioServicio.buscarPorUnicoIdUsuario(idUsuario);
    }

    @PutMapping
    public UsuarioDTO modificarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioServicio.modificar(usuarioDTO);
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public void eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioServicio.eliminar(idUsuario);
    }
}
