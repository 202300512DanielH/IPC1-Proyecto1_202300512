
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
    static int codigo = 0;
    
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
        codigo = codigo + 1;
        Paciente paciente_Nuevo = new Paciente(codigo, nombres, apellidos, password, sexo, edad, "Paciente");
        lista_Pacientes.add(paciente_Nuevo);
        JOptionPane.showMessageDialog(null, "Su código de inicio es:"+"\n"+codigo);        
        return null;
    }
    
    public void Crear_Doctor(String nombres, String apellidos, String password, int edad, String sexo, int telefono, String especialidad){
        codigo = codigo + 1;
        Doctor doctor_Nuevo = new Doctor(codigo,nombres,apellidos,password,sexo,edad,"Doctor",especialidad,telefono);
        lista_Doctores.add(doctor_Nuevo);
        JOptionPane.showMessageDialog(null, "Se a creado al doctor con exito, su codigo es:"+"\n"+codigo);        
    }
    
    public Persona buscar_Persona(int codigo_Unico,String rol){        
        if(rol.equals("Doctor")){
            for (int i = 0; i < lista_Doctores.size(); i++){
                Doctor doctor_Obtenido = lista_Doctores.get(i);
                if(doctor_Obtenido.getid() == codigo_Unico && doctor_Obtenido.getRol().equals(rol)){
                    return doctor_Obtenido;
                }
            }
        }else{
            for (int i = 0; i < lista_Pacientes.size(); i++){
                Paciente paciente_Obtenido = lista_Pacientes.get(i);
                if(paciente_Obtenido.getid() == codigo_Unico && paciente_Obtenido.getRol().equals(rol)){
                    return paciente_Obtenido;
                }
            }
        }
        
        return null;
    }
    
    public boolean eliminar_Persona(int codigo_Unico, String rol){
        if(rol.equals("Doctor")){
            for (int i = 0; i < lista_Doctores.size(); i++){
                Doctor doctor_Obtenido = lista_Doctores.get(i);
                if(doctor_Obtenido.getid() == codigo_Unico && doctor_Obtenido.getRol().equals(rol)){
                    lista_Doctores.remove(i);
                    return true;
                }
            }
        }else{
            for (int i = 0; i < lista_Pacientes.size(); i++){
                Paciente paciente_Obtenido = lista_Pacientes.get(i);
                if(paciente_Obtenido.getid() == codigo_Unico && paciente_Obtenido.getRol().equals(rol)){
                    lista_Pacientes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void actualizar_Doctor(int codigo_Unico, String nombres, String apellidos, String password, int edad, String sexo, int telefono, String especialidad){
        for (int i = 0; i < lista_Doctores.size(); i++){
            Doctor doctor_Obtenido = lista_Doctores.get(i);
            if(doctor_Obtenido.getid() == codigo_Unico){
                doctor_Obtenido.setNombre(nombres);
                doctor_Obtenido.setApellido(apellidos);
                doctor_Obtenido.setContraseña(password);
                doctor_Obtenido.setEdad(edad);
                doctor_Obtenido.setSexo(sexo);
                doctor_Obtenido.setTelefono(telefono);
                doctor_Obtenido.setEspecialidad(especialidad);
                lista_Doctores.set(i, doctor_Obtenido);
                break; // Termina el ciclo una vez que se actualiza el doctor
            }
        }
    }
    
    public void actualizar_Paciente(int codigo_Unico, String nombres, String apellidos, String password, int edad, String sexo){
        for(int i = 0; i < lista_Pacientes.size(); i++){
            Paciente paciente = lista_Pacientes.get(i);
            if(paciente.getid() == codigo_Unico){
                paciente.setNombre(nombres);
                paciente.setApellido(apellidos);
                paciente.setContraseña(password);
                paciente.setEdad(edad);
                paciente.setSexo(sexo);
                lista_Pacientes.set(i, paciente);
                break; // Termina el ciclo una vez que se actualiza el doctor
            }
        }
    }
    
    public void primer_Doctor(){
        lista_Doctores.add(new Doctor(codigo,"Doctor1","---","123","Masculino",20,"Doctor","Cirujano",123456));
    }
    
    public void agregarDoctores() {
        String[] nombres = {"Doctor1", "Doctor2", "Doctor3", "Doctor4", "Doctor5", "Doctor6", "Doctor7", "Doctor8", "Doctor9", "Doctor10",
                            "Doctor11", "Doctor12", "Doctor13", "Doctor14", "Doctor15", "Doctor16", "Doctor17", "Doctor18", "Doctor19", "Doctor20"};
        String[] especialidades = {"Cirujano", "Odontólogo", "Cardiólogo", "Pediatra", "Dermatólogo", "Neurólogo", "Oncólogo", "Ginecólogo", "Psiquiatra", "Traumatólogo",
                                   "Endocrinólogo", "Oftalmólogo", "Urologo", "Radiólogo", "Otorrinolaringólogo", "Nefrólogo", "Hematólogo", "Reumatólogo", "Geriatra", "Nutricionista"};

        for (int i = 0; i < nombres.length; i++) {
            codigo = codigo + 1;
            String especialidad = especialidades[i % especialidades.length]; // Obtener una especialidad diferente para cada doctor
            lista_Doctores.add(new Doctor(codigo, nombres[i], "---", "123", "Masculino", 20, "Doctor", especialidad, 123456));
        }
    }
    
    public ArrayList<Doctor> get_Lista_Doctores(){
        return lista_Doctores;
    }
    
}