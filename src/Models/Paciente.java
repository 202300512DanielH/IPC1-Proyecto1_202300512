
package Models;

import java.util.ArrayList;

//Se hace uso de la herencia para obtener las caracteristicas de Persona
public class Paciente extends Persona {
    
    public ArrayList<Cita> citas;
    
    // Constructor
    public Paciente(int codigo, String nombre, String apellido, String contraseña, String sexo, int edad, String rol) {
        super(codigo, nombre, apellido, contraseña, sexo, edad, rol);
        this.citas = new ArrayList<>();
    }

    // Método para obtener la lista de citas
    public ArrayList<Cita> getCitas() {
        return this.citas;
    }

    // Método para establecer la lista de citas
    public void agregarCita(Cita cita) {
        this.citas.add(cita);
    }
    
}

