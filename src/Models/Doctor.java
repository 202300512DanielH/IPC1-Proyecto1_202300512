
package Models;

import java.util.ArrayList;

public class Doctor extends Persona {
    private String especialidad;
    private int telefono;
    private ArrayList<Cita> citas;
    private ArrayList<String> horarios;
    
    // Constructor
    public Doctor(int codigo, String nombre, String apellido, String contraseña, String sexo, int edad, String rol, String especialidad, int telefono) {
        super(codigo, nombre, apellido, contraseña, sexo, edad, rol);
        this.especialidad = especialidad;
        this.telefono = telefono;
        citas = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    // Métodos para agregar y obtener citas
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    // Métodos para agregar y obtener horarios
    public void agregarHorario(String horario) {
        horarios.add(horario);
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    // Getters y setters para especialidad y telefono
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

