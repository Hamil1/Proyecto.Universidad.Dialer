/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hamil
 */
public class model {
    
    public static Connection conn;
    public static String query;
    public static PreparedStatement ps;
    public static Statement st ;
    
    
    public static void connection(String url, String database, String user) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:Dialer.db");
        System.out.println("Conexion creada!");
    }
    
    public static void insertCallBacks(String nombre, String apellido, String address, String ciudad, String telefono1, String telefono2, String telefono3, String description) throws SQLException{
        st = conn.createStatement();
        query = "INSERT INTO callbacks (nombre, apellido, address, ciudad, telefono1, telefono2, telefono3, description)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, address);
        ps.setString(4, ciudad);
        ps.setString(5, telefono1);
        ps.setString(6, telefono2);
        ps.setString(7, telefono3);
        ps.setString(8, description);
        ps.executeUpdate();
        System.out.println("Insert Exitoso!");
        conn.close();
        System.out.println("Conexion cerrada");
    }
    
}
