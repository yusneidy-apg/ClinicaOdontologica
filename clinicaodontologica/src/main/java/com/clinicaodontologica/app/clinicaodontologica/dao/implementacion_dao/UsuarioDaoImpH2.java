package com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao;


import com.clinicaodontologica.app.clinicaodontologica.dao.CrutBd;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Usuario;
import com.clinicaodontologica.app.clinicaodontologica.utilidad.ConexionBaseDeDatos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDaoImpH2 implements CrutBd<Usuario> {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioDaoImpH2.class);

    private final static String CREATE_TABLE_USUARIO = "create table if not exists usuario " +
            "(idUsuario int auto_increment primary key," +
            "usuario varchar (255)," +
            "contrasenia varchar(255),"+
            "rol varchar(255))," +
            "activo boolean;";


    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBaseDeDatos.obtenerConexion();
    }

    @Override
    public Usuario crear(Usuario usuario) throws SQLException, ClassNotFoundException {

        Statement stmtCrearTabla = getConexcion().createStatement();
        stmtCrearTabla.execute(CREATE_TABLE_USUARIO);

        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO usuario " +
                    "(usuario, contrasenia, rol, activo) " +
                    "VALUES(?, ?, ?, ?)");

        queryInsert.setString(1, usuario.getUsuario());
        queryInsert.setString(2, usuario.getContasenia());
        queryInsert.setString(3, usuario.getRol());
        queryInsert.setBoolean(4, usuario.getActivo());

        queryInsert.execute();
        LOGGER.info("¡Usuario creado con exito!");
        queryInsert.close();

        return null;
        }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = getConexcion().createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setUsuario(rs.getString(1));
                usuario.setContasenia(rs.getString(2));
                usuario.setRol(rs.getString(3));
                usuario.setActivo(rs.getBoolean(4));
                usuarios.add(usuario);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public void modificar(Usuario usuario) {

        try (PreparedStatement stmt = getConexcion().prepareStatement("UPDATE usuario set usuario = ?, contrasenia = ?, rol = ?, activo = ?, where idUsuario = ?")){
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContasenia());
            stmt.setString(3, usuario.getRol());
            stmt.setBoolean(4, usuario.getActivo());

            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        LOGGER.info("¡Usuario actualizado con exito!");
    }

    @Override
    public void eliminar(int id) {

        try (PreparedStatement stmt = getConexcion().prepareStatement("DELETED FROM usuario WHERE idUsuario = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Usuario eliminado con éxito!");

    }
}
