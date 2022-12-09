package com.clinicaodontologica.app.clinicaodontologica.servicios;

import com.clinicaodontologica.app.clinicaodontologica.dto.UsuarioDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;

import java.util.List;

public interface UsuarioServicio {

   UsuarioDTO crear(UsuarioDTO usuarioDTO) ;
   UsuarioDTO modificar(UsuarioDTO usuarioDTO) ;
   List<UsuarioDTO> listar();
    UsuarioDTO buscarPorId(Integer idUsuario) throws NoEncontradoException;
    void eliminar(int id);
    UsuarioDTO buscarPorUnicoUsuario(String usuario) ;

}
