package solopuertas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Registro extends ConexionSQL{
    
    PreparedStatement ps = null;
    ConexionSQL con = new ConexionSQL();
    
    public void registroCaja(String fecha, int codigo, String tipo, String descripcion, int monto){
        
        try {
            ps = con.conectar().prepareStatement("INSERT INTO tcaja VALUES(?,?,?,?,?)");
            ps.setString(1, fecha);
            ps.setString(2, String.valueOf(codigo));
            ps.setString(3, tipo);
            ps.setString(4, descripcion);
            ps.setInt(5, monto);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        }
    }
}
