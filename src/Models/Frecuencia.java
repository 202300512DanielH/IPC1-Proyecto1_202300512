
package Models;

public class Frecuencia {
    
    private int frecuencia;
    private String dato;

    public Frecuencia(String dato, int frecuencia) {
        this.frecuencia = frecuencia;
        this.dato = dato;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    public void incrementarFrecuencia() {
        this.frecuencia++;
    }
    
}
