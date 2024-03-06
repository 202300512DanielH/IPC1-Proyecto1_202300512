
package System;
import View.Ventana_Base;
import controller.Persona_Controller;

public class Main {
    
static Ventana_Base ventana_Base = new Ventana_Base();
static Persona_Controller persona_COntroller = new Persona_Controller();
    
    public static void main(String[] args) {
        persona_COntroller.agregarDoctores();
        ventana_Base.setVisible(true);
        ventana_Base.setLocationRelativeTo(null);
    }
    
    public Ventana_Base get_Ventana_Base(){    
        return ventana_Base;    
    } 
    
}
