/* 
 Project: Proyecto.Universidad.Dialer
 Package: model
 File: model 
 Created by Hamil on Jan 5, 2018 - 9:54:58 AM. 
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    /**
     * Este método es para hacer insert en la tabla CallBacks 
     * @param nombre
     * @param apellido
     * @param address
     * @param ciudad
     * @param telefono1
     * @param telefono2
     * @param telefono3
     * @param anotaciones
     * @param description
     * @throws SQLException 
     */
    public void insertCallBacks(String nombre, String apellido, String address, String ciudad, String telefono1, String telefono2, String telefono3,String anotaciones, String description) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:Dialer.db");
        System.out.println("Conexion creada!");
        st = conn.createStatement();
        query = "INSERT INTO callbacks (nombre, apellido, address, ciudad, telefono1, telefono2, telefono3, anotaciones, description)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, address);
        ps.setString(4, ciudad);
        ps.setString(5, telefono1);
        ps.setString(6, telefono2);
        ps.setString(7, telefono3);
        ps.setString(8, anotaciones);
        ps.setString(9, description);
        ps.executeUpdate();
        System.out.println("Insert Exitoso!");
        conn.close();
        System.out.println("Conexion cerrada.");
    }
    
    /**
     * Este método se utiliza para traer todos los clientes (Debe de cerrar la conexion a la Db)
     * @return Clientes
     * @throws SQLException 
     */
    
    public ResultSet selectAllClients() throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:Dialer.db");
        System.out.println("Conexion creada!");
        String query = "SELECT id, nombre, apellido, address, ciudad, telefono1, telefono2, telefono3 FROM clients";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    /**
     * Este método es para cerrar la conexion a la Db (Hay algunos metodos de la clase Model que no se puede cerrar la conexion)
     * @throws SQLException 
     */
    public void closeConnection() throws SQLException{
        conn.close();
        System.out.println("Conexion Cerrada.");
    }
    /**
     * Este metodo es para logear a los usuarios (Debe de cerrar la conexion a la Db)
     * @param usu
     * @param pas
     * @return
     * @throws SQLException 
     */
    public ResultSet selectUserLogin(String usu, String pas) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:Dialer.db");
        System.out.println("Conexion creada!");
        String query = "SELECT nombre, contrasena FROM users WHERE nombre = '"+usu+"' and contrasena = '"+pas+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    /**
     * Este método es para eliminar un cliente
     * @param id
     * @throws SQLException 
     */
    public void deleteClient(String id) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:Dialer.db");
        System.out.println("Conexion creada!");
        Statement st = conn.createStatement();
        String query = "DELETE FROM clients WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();
        conn.close();
        System.out.println("Conexion Cerrada.");
    }
    
}
