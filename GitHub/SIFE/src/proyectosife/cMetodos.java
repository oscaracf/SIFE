/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosife;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabio
 */
public class cMetodos {
    
    private final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final String DB_URL = "jdbc:derby://localhost:1527/SIFE";

    //  Database credentials
    private final String USER = "";
    private final String PASS = "";

    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pt = null;
    private ResultSet rs = null;

    cCliente cliente = new cCliente(0,"","","", "",0,0,0);
    
    private void tryConnectionDB() {
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        //STEP 3: Open a connection
            System.out.println("Connecting to database SIFE...");
            conn = DriverManager.getConnection(DB_URL);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error no se ha podido conectar a la Base de Datos", "Error de Conexión a la Base de Datos", JOptionPane.ERROR_MESSAGE);

        }
    }

    public DefaultTableModel loadDataTablePersona(int tipoPersona) {// cambiar nombre
        tryConnectionDB();
        System.out.println("Connection successfully");
        DefaultTableModel dtm = new DefaultTableModel();
        ResultSetMetaData meta;
        try {
            pt = conn.prepareStatement("Select ID_PERSONA, NOMBRE, APELLIDO, TELEFONO, DIRECCION, CORREO_ELECTRONICO, TIPO_CLIENTE, TIPO_PERSONA  from T_PERSONA where TIPO_PERSONA = ? ");
            pt.setInt(1, tipoPersona);
            rs = pt.executeQuery();
            meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnName(i));
            } while (rs.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; ++i) {
                    rowData[i] = rs.getObject(i + 1);
                    //System.out.println(rowData[i]);
                }
                dtm.addRow(rowData);
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error no se han podido cargar los datos de la tabla, por favor inténtelo más tarde", "Error de Conexión a la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return dtm;
    }
    
     public DefaultTableModel loadDataTable() {
        tryConnectionDB();
        System.out.println("Connection successfully");
        DefaultTableModel dtm = new DefaultTableModel();
        ResultSetMetaData meta;
        try {
            pt = conn.prepareStatement("Select * from T_PERSONA");
            rs = pt.executeQuery();
            meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnName(i));
            }

            while (rs.next()) {

                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; ++i) {
                    rowData[i] = rs.getObject(i + 1);
                   // System.out.println(rowData[i]);
                }
                dtm.addRow(rowData);
            }
           // System.out.println("DTM: " + dtm);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error no se han podido cargar los datos de la tabla, por favor inténtelo más tarde", "Error de Conexión a la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return dtm;
    }
    
    public void searchByIdClient(int id, int tipoPersona){
        tryConnectionDB();
        System.out.println("Connection successfully");
        
        ResultSetMetaData meta;
        try {
            pt = conn.prepareStatement("SELECT * FROM T_PERSONA WHERE ID_PERSONA = ? AND TIPO_PERSONA = ? ");
            pt.setInt(1, id);
            pt.setInt(2, tipoPersona);
            rs = pt.executeQuery();
            meta = rs.getMetaData();
            
            while (rs.next()) {
                cliente.setIdPersona(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getInt(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setCorreoElectronico(rs.getString(6));
                cliente.setTipoCliente(rs.getInt(9));
                cliente.setTipoPersona(rs.getInt(11));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public boolean insertClient(int id, String nombre, String apellido,int telefono, String direccion,
    String correo, int tipoCliente,int tipoPersona){
//        int idProvee= null, idEmpleado= null;
        boolean confirmacion = false;
        String contrasenna = "";
        tryConnectionDB();
        System.out.println("Connection successfully");
        
        ResultSetMetaData meta;
        try {
            pt = conn.prepareStatement("INSERT INTO T_PERSONA VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pt.setInt(1,id);
            pt.setString(2, nombre);
            pt.setString(3, apellido);
            pt.setInt(4, telefono);
            pt.setString(5, direccion);
            pt.setString(6, correo);
            pt.setNull(7, java.sql.Types.INTEGER );
            pt.setNull(8,java.sql.Types.INTEGER );
            pt.setInt(9, tipoCliente);
            pt.setString(10, contrasenna);
            pt.setInt(11, tipoPersona);
            pt.executeUpdate();
            meta = rs.getMetaData();
            
            while (rs.next()) {
                cliente.setIdPersona(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getInt(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setCorreoElectronico(rs.getString(6));
                cliente.setTipoCliente(rs.getInt(9));
                cliente.setTipoPersona(rs.getInt(11));
            }
            confirmacion =  true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            confirmacion =  false;
        }
        return confirmacion;
    }
    
    public void updateClient(int id, String nombre, String apellido,int telefono, String direccion,
    String correo, int tipoCliente,int tipoPersona){
        tryConnectionDB();
        System.out.println("Connection successfully");
        
        ResultSetMetaData meta;
        try {
            pt = conn.prepareStatement("UPDATE T_PERSONA SET NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, DIRECCION = ?, CORREO_ELECTRONICO = ?, TIPO_CLIENTE = ? WHERE ID_PERSONA = ? AND TIPO_PERSONA = ? ");
            
            pt.setString(1, nombre);
            pt.setString(2, apellido);
            pt.setInt(3, telefono);
            pt.setString(4, direccion);
            pt.setString(5, correo);
            pt.setInt(6, tipoCliente);
            pt.setInt(7,id);
            pt.setInt(8, tipoPersona);
            pt.executeUpdate();
            meta = rs.getMetaData();
            System.out.println("Actualizado");
            while (rs.next()) {
                cliente.setIdPersona(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setTelefono(rs.getInt(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setCorreoElectronico(rs.getString(6));
                cliente.setTipoCliente(rs.getInt(9));
                cliente.setTipoPersona(rs.getInt(11));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public void deleteClient(int id, int tipoPersona){
        tryConnectionDB();
        System.out.println("Connection successfully");
       
        try {
            pt = conn.prepareStatement("DELETE FROM T_PERSONA WHERE ID_PERSONA = ? AND TIPO_PERSONA = ? ");
            pt.setInt(1, id);
            pt.setInt(2, tipoPersona);
            pt.executeUpdate();
            System.out.println("Eliminado");
         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public String getTypeClient(int tipoCliente){
       
        String tipoClienteS;
        switch(tipoCliente){
            case 1:
                tipoClienteS = "Contado";   
            break;
            case 2:
               tipoClienteS = "Crédito";   
            break;
            default:
                tipoClienteS = " .............";   
            break;
        } 
        return tipoClienteS;
    }
    
    public String getTypePerson(int tipoPersona){
        String tipoPersonaS;
        switch(tipoPersona){
            case 1:
                tipoPersonaS = "Cliente";   
            break;
            case 2:
               tipoPersonaS = "Proveedor";   
            break;
            case 3:
               tipoPersonaS = "Empleado";   
            break;
            default:
                tipoPersonaS = ".............";   
            break;
        } 
        return tipoPersonaS;
    }
    
    public int getTypeClientInt(String tipoCliente){
               
        int tipoClienteI;
        switch(tipoCliente){
            case "Contado":
                tipoClienteI = 1;   
            break;
            case "Crédito":
               tipoClienteI = 2;   
            break;
            default:
                tipoClienteI = 0;   
            break;
        } 
        return tipoClienteI;
    }
}
