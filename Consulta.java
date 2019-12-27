package solopuertas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
    ConexionSQL con = new ConexionSQL();
    private ResultSet r = null;
    private Statement s = null;
    private String tabla = null;

    public Consulta(String tabla) {
        this.tabla = tabla;  
    }
    
    public int contarColumnas(){
        String consulta = "select * from " + tabla;
        int n = 0;
        
        try {
            s = con.conectar().createStatement();           
            r = s.executeQuery(consulta);
            r.beforeFirst();

            while (r.next()){
                n++;
            }
    
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        }
        return n;
    }

    public Object[][] consultaCaja(String tipo){

        String consulta1 = "select * from "+ tabla + " where Tipo = '" + tipo + "'";
        Object[][] items = new Object[contarColumnas()][5];
        int i = 0;
        System.out.println(contarColumnas());
        try {
            s = con.conectar().createStatement();           
            r = s.executeQuery(consulta1);
            r.beforeFirst();

            while (r.next()){
                
                items[i][0] = r.getString(1);
                items[i][1] = r.getInt(2);
                items[i][2] = r.getString(3);
                items[i][3] = r.getString(4);
                items[i][4] = r.getInt(5); 
                i++;
                
            }
        } catch (SQLException ex) {
            System.err.println("Errooor: " + ex);
        }
    return items;    
    }
}
