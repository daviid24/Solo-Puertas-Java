package solopuertas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionSQL {

    private final String user = "solopuertas";
    private final String password = "12345678";
    private final String host = "3306";
    private final String db = "dbsolopuertas";
    
    
    public Connection conectar(){
        
        Connection con = null;               
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:"+ host + "/" + db, user, password);
           
            System.out.println("Conexión Exitosa");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erroooor" + ex);
        }
         return con;
    }
    public void consulta(){
        ConexionSQL con = new ConexionSQL();
        ResultSet r = null;
        Statement s = null;
        String consulta1 = "select * from tventas";
        
        try {
            s = con.conectar().createStatement();           
            r = s.executeQuery(consulta1);
            r.beforeFirst();
            r.next();
            System.out.println(r.getInt("codigo") + r.getString("producto"));
            
            
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        }
            
    }   
}