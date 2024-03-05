
package controller;

import Models.Doctor;
import Models.Paciente;
import java.util.ArrayList;
import Models.Persona;
import javax.swing.JOptionPane;

public class Persona_Controller {
    
    static Panel_Controller panel_Control = new Panel_Controller();
    static javax.swing.JPanel cambioPanel = null;
    static ArrayList<Paciente> lista_Pacientes = new ArrayList<Paciente>();
    static ArrayList<Doctor> lista_Doctores = new ArrayList<Doctor>();
    static Persona admin = new Persona(202300512, "admin", "", "proyecto1IPC1", "", 0, "ADMIN");
    static int id_Persona_Logueada;
    static String rol_Persona_Logueada;
    
    public javax.swing.JPanel Login(int codigo, String password){
        
        if (admin.getid() == codigo && admin.getContraseña().equals(password)){
            id_Persona_Logueada = admin.getid();
            rol_Persona_Logueada = admin.getRol();
            cambioPanel = panel_Control.get_Panel_Menu_Administrador();
            JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");            
            return cambioPanel;
        }
        
        for (int i = 0; i < lista_Pacientes.size(); i++){
            Persona persona = lista_Pacientes.get(i);
            if (persona.getid() == codigo && persona.getContraseña().equals(password)){
                id_Persona_Logueada = persona.getid();
                rol_Persona_Logueada = persona.getRol();
                JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");
                return null;
            }
        }
        
        for (int i = 0; i < lista_Doctores.size(); i++){
            Persona persona = lista_Doctores.get(i);
            if (persona.getid() == codigo && persona.getContraseña().equals(password)){
                id_Persona_Logueada = persona.getid();
                rol_Persona_Logueada = persona.getRol();
                JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");
                return null;
            }
        }
        JOptionPane.showMessageDialog(null,"Contraseña o codigo incorrecto");
        return null;
    }
    
    public javax.swing.JPanel Registrarse(String nombres, String apellidos, String password, int edad, String sexo){
        int codigo = lista_Pacientes.size();
        Paciente paciente_Nuevo = new Paciente(codigo, nombres, apellidos, password, sexo, edad, "Paciente");
        lista_Pacientes.add(paciente_Nuevo);
        JOptionPane.showMessageDialog(null, "Su código de inición es:"+"\n"+codigo);        
        return null;
    }
    
    public void Crear_Doctor(String nombres, String apellidos, String password, int edad, String sexo, int telefono, String especialidad){
        int codigo = lista_Doctores.size();
        Doctor doctor_Nuevo = new Doctor(codigo,nombres,apellidos,password,sexo,edad,"Dcotor",especialidad,telefono);
        lista_Doctores.add(doctor_Nuevo);
        JOptionPane.showMessageDialog(null, "Se a creado al doctor con exito, su codigo es:"+"\n"+codigo);        
    }
    
    public ArrayList<Paciente> get_Lista_Usuarios(){
        return lista_Pacientes;
    }
}
