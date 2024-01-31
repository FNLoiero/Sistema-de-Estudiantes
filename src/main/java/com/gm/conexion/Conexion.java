package com.gm.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "estudiantes_bd";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "admin";
        // cargamos la clase del driver de my sql en memoria

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ocurrio en la conexion: " + e.getMessage());
        }

        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion != null)
            System.out.println("conexion exitosa: " + conexion);
        else
            System.out.println("error al conectarse");
    }
}
