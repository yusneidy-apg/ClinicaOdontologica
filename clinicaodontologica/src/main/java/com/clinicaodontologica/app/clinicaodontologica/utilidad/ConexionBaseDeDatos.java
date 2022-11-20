package com.clinicaodontologica.app.clinicaodontologica.utilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/citas_medicas";
    private final static String DB_USER ="root";
    private final static String DB_PASSWORD = "";
    private static Connection connection;

    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        if(connection == null){
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }
}
