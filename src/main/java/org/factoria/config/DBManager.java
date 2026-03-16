package org.factoria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final String URL = "jdbc:mysql://localhost:3306/videoclub_app";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


public static Connection connection;

public static Connection InitConnection() {
    try {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexión exitosa BBDD");

    } catch (SQLException exception) {
        System.out.println("Conexión errónea : " + exception.getMessage());

    }
    return connection;
}
public static void closeConnection(){
    try{
        connection.close();
        System.out.println("Conexión cerrada exitosamente");
    } catch (SQLException exception) {
        System.out.println("Error al cerrar BBDD : " + exception.getMessage());
    }
  }


}



