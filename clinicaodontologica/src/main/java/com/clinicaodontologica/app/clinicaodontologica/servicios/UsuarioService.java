package com.clinicaodontologica.app.clinicaodontologica.servicios;


import com.clinicaodontologica.app.clinicaodontologica.dao.CrutBd;
import com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao.UsuarioDaoImpH2;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final CrutBd<Usuario> usuario;
    @Autowired
    public UsuarioService( UsuarioDaoImpH2 usuarioDaoImpH2) {
        this.usuario = usuarioDaoImpH2;
    }

    public Usuario guardarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        return this.usuario.crear(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuario.listar();
    }


    public void modificarUsuario(Usuario usuario){
        this.usuario.modificar(usuario);
    }

    public void eliminarUsuario(int id){
        usuario.eliminar(id);
    }
}
