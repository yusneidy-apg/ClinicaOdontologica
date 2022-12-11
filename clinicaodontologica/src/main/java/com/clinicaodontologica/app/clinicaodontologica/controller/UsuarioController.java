package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.dto.PeticionAutenticacion;
import com.clinicaodontologica.app.clinicaodontologica.dto.RespuestaAutenticacion;
import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioParcialDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.RecursoCreadoException;
import com.clinicaodontologica.app.clinicaodontologica.seguridad.UsuarioServicioImpl;
import com.clinicaodontologica.app.clinicaodontologica.seguridad.jwt.UtilidadJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final AuthenticationManager authenticationManager;

    private final UsuarioServicioImpl usuarioServicio;

    private final UtilidadJwt utilidadJwt;

    @Autowired
    public UsuarioController(UsuarioServicioImpl usuarioServicio, AuthenticationManager authenticationManager, UtilidadJwt utilidadJwt) {
        this.usuarioServicio = usuarioServicio;
        this.authenticationManager = authenticationManager;
        this.utilidadJwt = utilidadJwt;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody PeticionAutenticacion authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception("Error al autenticar", e);
        }
        final UserDetails userDetails = usuarioServicio.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = utilidadJwt.generarToken(userDetails);

        return ResponseEntity.ok(new RespuestaAutenticacion((jwt)));
    }

    @PostMapping
    public UsuarioParcialDTO crearUsuario (@RequestBody UsuarioDTO usuarioDTO) throws RecursoCreadoException {
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
