package solopuertas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Principal {
    Date fecha;
    //public static void main(String[] args) {
           //ConexionSQL sql = new ConexionSQL();
           //sql.consulta();
     //       Principal pr = new Principal();
       //     pr.pruebas();
    //}
    public void pruebas(){
        fecha = new Date();
        DayOfWeek lunes = DayOfWeek.SUNDAY; 
        System.out.printf("8 días será: %s%n",lunes.plus(4));
        LocalDateTime ahora = LocalDateTime.now(); 
        System.out.printf("La hora es: %s%n", ahora);
        LocalDate date = LocalDate.now();
        System.out.printf("el dia de hoy es: " + date);
        //System.out.print(fecha.getTime());
    }
    
}
