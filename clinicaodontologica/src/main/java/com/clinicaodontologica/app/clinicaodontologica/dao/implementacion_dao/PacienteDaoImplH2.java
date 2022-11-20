package com.clinicaodontologica.app.clinicaodontologica.dao.implementacion_dao;


import com.clinicaodontologica.app.clinicaodontologica.dao.CrutBd;
import com.clinicaodontologica.app.clinicaodontologica.modelos.Paciente;
import com.clinicaodontologica.app.clinicaodontologica.utilidad.ConexionBaseDeDatos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PacienteDaoImplH2 implements CrutBd<Paciente> {

    private static final Logger LOGGER = LogManager.getLogger(PacienteDaoImplH2.class);

    private final static String CREATE_TABLE_PACIENTE = "create table if not exists paciente " +
            "(idPaciente int auto_increment primary key," +
            "nombre varchar(255)," +
            "apellido varchar(255),"+
            "domicilio varchar(255)," +
            "dni varchar(25)," +
            "fechaAlta DATE);";

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBaseDeDatos.obtenerConexion();
    }


    @Override
    public Paciente crear(Paciente paciente) throws SQLException, ClassNotFoundException {

        Statement stmtCrearTabla = getConexcion().createStatement();
        stmtCrearTabla.execute(CREATE_TABLE_PACIENTE);


        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO paciente " +
                "(nombre,apellido,domicilio,dni, fechaAlta) " +
                "VALUES(?, ?, ?, ?, ?)");

        queryInsert.setString(1, paciente.getNombre());
        queryInsert.setString(2, paciente.getApellido());
        queryInsert.setString(3, paciente.getDomicilio());
        queryInsert.setString(4, paciente.getDni());
        queryInsert.setTimestamp(5, Timestamp.valueOf(paciente.getFechaAlta()));

        queryInsert.execute();
        LOGGER.info("¡Paciente creado con exito!");
        queryInsert.close();

        return null;
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> pacientes = new ArrayList<>();

        try(Statement stmt = getConexcion().createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM paciente");
            while (rs.next()){
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt(1));
                paciente.setNombre(rs.getString(2));
                paciente.setApellido(rs.getString(3));
                paciente.setDomicilio(rs.getString(4));
                paciente.setDni(rs.getString(5));
                paciente.setFechaAlta(rs.getTimestamp(6).toLocalDateTime());
                pacientes.add(paciente);
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return pacientes;
    }

    @Override
    public void modificar(Paciente paciente) {

        try (PreparedStatement stmt = getConexcion().prepareStatement("UPDATE paciente set nombre = ?, apellido = ?, domicilio = ?, dni = ?, fechaAlta = ?,  where idPaciente = ?")){
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getDomicilio());
            stmt.setString(4, paciente.getDni());
            stmt.setTimestamp(5, Timestamp.valueOf(paciente.getFechaAlta()));
            stmt.setInt(6, paciente.getIdPaciente());
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Paciente actualizado con exito!");
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = getConexcion().prepareStatement("DELETED FROM paciente WHERE idPaciente = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Paciente eliminado con éxito!");


    }
}
