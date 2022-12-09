package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;

import java.util.List;

public interface UsuarioServicio {

   UsuarioDTO crear(UsuarioDTO usuarioDTO) throws NoEncontradoException;
   UsuarioDTO modificar(UsuarioDTO usuarioDTO) throws NoEncontradoException;
   List<UsuarioDTO> listar();
    UsuarioDTO buscarPorId(Integer idUsuario);
    void eliminar(int id);
    UsuarioDTO buscarPorUnicoUsuario(String usuario) throws NoEncontradoException;

}
