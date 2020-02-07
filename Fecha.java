package solopuertas;

import java.time.LocalDate;

public class Fecha {
    private LocalDate ldFecha = LocalDate.now();
    private String fecha = ldFecha.toString();
    
    public void setFecha(int dia, int mes, int ano){
        ldFecha = ldFecha.withDayOfYear(dia);
        ldFecha = ldFecha.withMonth(mes);
        ldFecha = ldFecha.withYear(ano);
    
        fecha = ldFecha.toString();
    }

    public String getFecha() {
        return fecha;
    }
}
