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
    
    public Connection conn;
    public String query;
    public PreparedStatement ps;
    public Statement st ;
    
    /**
     * Este método es para abrir la conexión a la base de datos de nuestra preferencia
     * @throws SQLException 
     */
    public void openConnection() throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite::resource:db/Dialer.db");
        System.out.println("\nConexion creada!");
    }
    
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
        this.openConnection();
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
        System.out.println("\nInsert Exitoso!");
        this.closeConnection();
    }
    
    /**
     * Este método es para traer todos los clientes (Puede especificar cuales campos quiere y debe de cerrar la conexion)
     * @param id
     * @param nombre
     * @param apellido
     * @param address
     * @param ciudad
     * @param telefono1
     * @param telefono2
     * @param telefono3
     * @param cedula
     * @param datacredito
     * @param score
     * @param where
     * @return
     * @throws SQLException 
     */
    
    public ResultSet selectAllClients(boolean id, boolean nombre, boolean apellido, boolean address, boolean ciudad, boolean telefono1, boolean telefono2, boolean telefono3, boolean cedula, boolean datacredito, boolean score, String where) throws SQLException{
        this.openConnection();
        String campos;
        campos = (id)?"id, ":"";
        campos += (nombre)?"nombre":"";
        campos += (apellido)?", ":"";
        campos += (apellido)?"apellido":"";
        campos += (address)?", ":"";
        campos += (address)?"address":"";
        campos += (ciudad)?", ":"";
        campos += (ciudad)?"ciudad":"";
        campos += (telefono1)?", ":"";
        campos += (telefono1)?"telefono1":"";
        campos += (telefono2)?", ":"";
        campos += (telefono2)?"telefono2":"";
        campos += (telefono3)?", ":"";
        campos += (telefono3)?"telefono3":"";
        campos += (cedula)?", ":"";
        campos += (cedula)?"cedula":"";
        campos += (datacredito)?", ":"";
        campos += (datacredito)?"datacredito":"";
        campos += (score)?", ":"";
        campos += (score)?"score":"";
        String query = "SELECT "+ campos +" FROM clients " + where;
        System.out.println("Este es el query: "+query);
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
        System.out.println("\nConexion Cerrada.");
    }
    /**
     * Este metodo es para logear a los usuarios (Debe de cerrar la conexion a la Db)
     * @param usu
     * @param pas
     * @return
     * @throws SQLException 
     */
    public ResultSet selectUser(String usu, String pas) throws SQLException{
        this.openConnection();
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
        this.openConnection();
        Statement st = conn.createStatement();
        String query = "DELETE FROM clients WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();
        System.out.println("\nDelete exitoso!");
        this.closeConnection();
    }
    /**
     * Este metodo es para insertar clientes en la base de datos
     * @param nombre
     * @param apellido
     * @param address
     * @param ciudad
     * @param telefono1
     * @param telefono2
     * @param telefono3
     * @throws SQLException 
     */
    public void insertClients(String nombre,String apellido,String address,String ciudad,String telefono1,String telefono2,String telefono3, String cedula) throws SQLException{
        this.openConnection();
        Statement st = conn.createStatement();
        String query = "INSERT INTO clients (nombre, apellido, address, ciudad, telefono1, telefono2, telefono3, cedula)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, address);
        ps.setString(4, ciudad);
        ps.setString(5, telefono1);
        ps.setString(6, telefono2);
        ps.setString(7, telefono3);
        ps.setString(8, cedula);
        ps.executeUpdate();
        System.out.println("\nInsert exitoso!");
        this.closeConnection();
    }
    /**
     * Este método es para darle update a un cliente en especifico (en el parametro Where se puede poner el where igual como en la base de datos).
     * @param nombre
     * @param apellido
     * @param direccion
     * @param ciudad
     * @param telefono1
     * @param telefono2
     * @param telefono3
     * @param where
     * @throws SQLException 
     */
    public void updateClient(String nombre,String apellido,String direccion,String ciudad,String telefono1,String telefono2,String telefono3, String where) throws SQLException{
        this.openConnection();
        Statement st = conn.createStatement();
        String query = "UPDATE clients SET nombre = ?, apellido = ?, address = ?, ciudad = ?, telefono1 = ?, telefono2 = ?, telefono3 = ?"
                    + " WHERE "+where;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, direccion);
        ps.setString(4, ciudad);
        ps.setString(5, telefono1);
        ps.setString(6, telefono2);
        ps.setString(7, telefono3);
        ps.executeUpdate();
        System.out.println("\nUpdate exisoto!");
        this.closeConnection();
    }
    /**
     * Este método sirve para traer todos los callbacks guardados por el usuario (se le puede especificar cuales campos queremos que traiga).
     * @param id
     * @param nombre
     * @param apellido
     * @param address
     * @param telefono1
     * @param telefono2
     * @param telefono3
     * @param description
     * @param anotaciones
     * @return
     * @throws SQLException 
     */
    public ResultSet selectAllCallBacks(boolean id, boolean nombre, boolean apellido, boolean address, boolean telefono1, boolean telefono2, boolean telefono3, boolean description, boolean anotaciones) throws SQLException{
        this.openConnection();
        String campos;
        campos = (id)?"id, ":"";
        campos += (nombre)?"nombre":"";
        campos += (apellido)?", ":"";
        campos += (apellido)?"apellido":"";
        campos += (address)?", ":"";
        campos += (address)?"address":"";
        campos += (telefono1)?", ":"";
        campos += (telefono1)?"telefono1":"";
        campos += (telefono2)?", ":"";
        campos += (telefono2)?"telefono2":"";
        campos += (telefono3)?", ":"";
        campos += (telefono3)?"telefono3":"";
        campos += (description)?", ":"";
        campos += (description)?"description":"";
        campos += (anotaciones)?", ":"";
        campos += (anotaciones)?"anotaciones":"";
        String query = "SELECT "+campos+" FROM callbacks";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
        
    }
    
}
