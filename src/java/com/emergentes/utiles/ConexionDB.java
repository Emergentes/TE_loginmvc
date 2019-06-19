package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_agenda";
    static String usuario = "root";
    static String password = "";
    
    public Connection conn = null;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            
            if (conn != null){
                System.out.println("Conexion OK " + conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Falta driver de la BD");
        } catch (SQLException ex){
            System.out.println("Error en SQL " + ex.getMessage());
        }
    }
    
    public Connection conectar()
    {
        return conn;
    }
    
    public void desconectar()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD " + ex.getMessage());
        }
    }
    
}
