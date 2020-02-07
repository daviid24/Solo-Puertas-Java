package solopuertas;

public class Pr_Puertas extends Productos{

    private String tablero;
    private boolean sentido;
    
    public Pr_Puertas(String tablero, boolean sentido, double alto, double ancho, String color) {
        super(alto, ancho, color);
        this.tablero = tablero;
        this.sentido = sentido;
    }

    public void costo(){
        
    }
    
    
    public String getTablero() {
        return tablero;
    }

    public void setTablero(String tablero) {
        this.tablero = tablero;
    }

    public boolean isSentido() {
        return sentido;
    }

    public void setSentido(boolean sentido) {
        this.sentido = sentido;
    }
    
    
}
