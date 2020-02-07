package solopuertas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConexionSQL{
    
    private final String user = "solopuertas";
    private final String password = "12345678";
    private final String host = "3306";
    private final String db = "db_solopuertas";
    //ResultSet r = null;
    Statement s = null;
    PreparedStatement ps = null;
    
    
    //Metodos abstractos
    public abstract void insertarSQL();
    public abstract void modificarSQL();
    public abstract void eliminarSQL();
    public abstract void consultarSQL();
    public abstract void lista();

    //Metodo de conexion SQL - Retorna variable tipo conexion
    public Connection conectar(){
        
        Connection con = null;               
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:"+ host + "/" + db, user, password);
           
            //System.out.println("Conexión Exitosa");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erroooor" + ex);
        }
         return con;
    }

    //Metodo para buscar un dato en especifico de una tabla - retorna el valor buscado
    public String buscar(String table,String valor, String nombreCol, int indiceCol){
                
        String dato = "";
        try {
            s = conectar().createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM " + table + " WHERE " + nombreCol + " = '" + valor + "'");
            r.beforeFirst();
            r.next();
            
            dato = r.getString(indiceCol);
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        }

        return dato;
    }
    public String codigo(String tabla, String indicativo,String columna){
        int i = 0;
        String codigo = "";

        try {
            s = conectar().createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM " + tabla + " WHERE " + columna + " = '" + indicativo + "'");

            r.beforeFirst();
            while(r.next()){
                i++;
            }
            
            codigo = indicativo + String.valueOf(10001 + i);
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        } 
        
        return codigo;
    }
    
    public String codigo(String tabla, String indicativo){
        int i = 0;
        String codigo = "";
      
        try {
            s = conectar().createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM " + tabla);

            r.beforeFirst();
            while(r.next()){
                i++;
            }
            
            codigo = indicativo + String.valueOf(10001 + i);
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        } 
        
        return codigo;
    }
    
    
    
}
