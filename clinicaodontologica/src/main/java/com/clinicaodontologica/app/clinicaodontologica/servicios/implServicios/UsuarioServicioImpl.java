package com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios;


import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.entities.Usuario;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.repositorio.UsuarioRepositorio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.UsuarioServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    ObjectMapper mapper = new ObjectMapper();
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    @Override
    public UsuarioDTO crear(UsuarioDTO usuarioDTO) throws NoEncontradoException {
        Usuario usuario = mapper.convertValue(usuarioDTO, Usuario.class);
        UsuarioDTO usuarioGuardado = buscarPorUnicoUsuario(usuarioDTO.getUsuario());
        if (usuarioGuardado != null)
            usuario.setIdUsuario(usuarioGuardado.getIdUsuario());
        return  mapper.convertValue(usuarioRepositorio.save(usuario), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO modificar(UsuarioDTO usuarioDTO) throws NoEncontradoException {
        return crear(usuarioDTO);
    }

    @Override
    public UsuarioDTO buscarPorId (Integer idUsuario) {
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
    public UsuarioDTO buscarPorUnicoUsuario(String usuario) throws NoEncontradoException {
        Usuario usuarioGuardado = usuarioRepositorio.findByUsuario(usuario);
        if(usuarioGuardado == null){
            throw new NoEncontradoException("El usuario " + usuario + " no fuen encontrado en la base de datos");
        }
        return mapper.convertValue(usuarioGuardado, UsuarioDTO.class);
    }
}
