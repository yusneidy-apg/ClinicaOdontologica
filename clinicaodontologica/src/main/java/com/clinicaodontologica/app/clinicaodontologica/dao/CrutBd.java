package com.clinicaodontologica.app.clinicaodontologica.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrutBd<T> {

    T crear(T t) throws SQLException, ClassNotFoundException;

    List<T> listar();

    void modificar(T t);

    void eliminar(int id);

}
