package com.clinicaodontologica.app.clinicaodontologica.seguridad;


import com.clinicaodontologica.app.clinicaodontologica.controller.UsuarioController;
import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioParcialDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Usuario;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.RecursoCreadoException;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.UsuarioRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.UsuarioServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioServicioImpl implements UsuarioServicio, UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);

    ObjectMapper mapper = new ObjectMapper();
    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioParcialDTO crear(UsuarioDTO usuarioDTO) throws RecursoCreadoException {
        Usuario usuario = mapper.convertValue(usuarioDTO, Usuario.class);
        UsuarioDTO usuarioGuardado = buscarPorUnicoUsuario(usuarioDTO.getUsuario());
        if (usuarioGuardado != null) {
            LOGGER.warn("¡Usuario " + usuarioGuardado.getUsuario() +  " ya creado!");
            throw new RecursoCreadoException("¡El usuario " + usuarioGuardado.getUsuario() + " ya se encuentra creado!");
        }
/*      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String contra = passwordEncoder.encode(usuario.getContrasenia());*/
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        LOGGER.info("¡Usuario creado con éxito!");
        return mapper.convertValue(usuarioRepositorio.save(usuario), UsuarioParcialDTO.class);
    }

    @Override
    public UsuarioDTO modificar(UsuarioDTO usuarioDTO) throws NoEncontradoException {
        UsuarioDTO usuarioGuardado = buscarPorId(usuarioDTO.getIdUsuario());
        usuarioGuardado.setUsuario(usuarioDTO.getUsuario());
        usuarioGuardado.setContrasenia(usuarioDTO.getContrasenia());
        usuarioGuardado.setRol(usuarioDTO.getRol());
        usuarioGuardado.setActivo(usuarioDTO.getActivo());
        return mapper.convertValue(usuarioRepositorio.save(mapper.convertValue(usuarioGuardado, Usuario.class)), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO buscarPorId(Integer idUsuario) throws NoEncontradoException {
        Usuario usuarioGuardado = usuarioRepositorio.findById(idUsuario).orElse(null);
        if (usuarioGuardado == null) {
            throw new NoEncontradoException("El usuario con el id " + idUsuario + " no fue encontrado en la base de datos");
        }
        return mapper.convertValue(usuarioRepositorio.findById(idUsuario).orElse(new Usuario()), UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<Usuario> listaUsuario = usuarioRepositorio.findAll();
        List<UsuarioDTO> listaRetorno = new ArrayList<>();
        listaUsuario.forEach(usuario -> {
            listaRetorno.add(mapper.convertValue(usuario, UsuarioDTO.class));
        });
        return listaRetorno;
    }

    @Override
    public void eliminar(int id) {
        usuarioRepositorio.deleteById(id);

    }

    @Override
    public UsuarioDTO buscarPorUnicoUsuario(String usuario) {
        return mapper.convertValue(usuarioRepositorio.findByUsuario(usuario), UsuarioDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByUsuario(username);
        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        GrantedAuthority autorizacion = new SimpleGrantedAuthority(usuario.getRol());
        autorizaciones.add(autorizacion);
        User userDetail =
                new User(
                        usuario.getUsername(),
                        usuario.getPassword(),
                        usuario.getActivo(),
                        true,
                        true,
                        true,
                        autorizaciones);
        return userDetail;
    }
}
