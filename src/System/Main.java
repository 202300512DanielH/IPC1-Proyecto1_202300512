
package System;
import View.Ventana_Base;
import controller.Persona_Controller;
import controller.Productos_Controller;

public class Main {
    
static Ventana_Base ventana_Base = new Ventana_Base();
static Persona_Controller persona_COntroller = new Persona_Controller();
static Productos_Controller producto_Controller = new Productos_Controller();
    
    public static void main(String[] args) {
        persona_COntroller.agregarDoctores();
        producto_Controller.crearProductos();
        persona_COntroller.agregarPacientes();
        ventana_Base.setVisible(true);
        ventana_Base.setLocationRelativeTo(null);
    }
    
    public Ventana_Base get_Ventana_Base(){    
        return ventana_Base;    
    } 
    
}
