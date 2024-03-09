
package controller;

import Models.Cita;
import Models.Doctor;
import Models.Frecuencia;
import Models.Paciente;
import java.util.ArrayList;
import Models.Persona;
import java.util.Collections;
import java.util.Comparator;
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
                cambioPanel = panel_Control.get_Panel_Menu_Paciente();
                JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");
                return cambioPanel;
            }
        }
        
        for (int i = 0; i < lista_Doctores.size(); i++){
            Persona persona = lista_Doctores.get(i);
            if (persona.getid() == codigo && persona.getContraseña().equals(password)){
                id_Persona_Logueada = persona.getid();
                rol_Persona_Logueada = persona.getRol();
                JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");
                cambioPanel = panel_Control.get_Panel_Menu_Doctor();
                return cambioPanel;
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
        
        agregarHorariosADoctores();
    }
    
    public void agregarHorariosADoctores() {
        // Lista de horarios
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("8:00");
        horarios.add("13:00");
        horarios.add("16:00");

        // Recorrer la lista de doctores y asignar los horarios
        for (Doctor doctor : lista_Doctores) {
            for (String horario : horarios) {
                doctor.agregarHorario(horario);
            }
        }
    }
    
    public void agregarPacientes() {
        String[] nombres = {"Paciente1", "Paciente2", "Paciente3", "Paciente4", "Paciente5",
                            "Paciente6", "Paciente7", "Paciente8", "Paciente9", "Paciente10"};
        int[] edades = {20, 15, 30, 45};
        for (int i = 0; i < 10; i++) {
            codigo++;
            String nombre = nombres[i % nombres.length];
            int edad = edades[i % edades.length];
            lista_Pacientes.add(new Paciente(codigo, nombre, "---", "123", "Masculino", edad, "Paciente"));
        }
    }
    
    public ArrayList<Frecuencia> registrarFrecuenciaEspecialidad() {
        // Lista para almacenar las frecuencias de las especialidades
        ArrayList<Frecuencia> frecuencias = new ArrayList<>();
        // Iterar sobre la lista de doctores
        for (Doctor doctor : lista_Doctores) {
            boolean encontrada = false;
            // Buscar si ya existe la especialidad en la lista de frecuencias
            for (Frecuencia frecuencia : frecuencias) {
                if (frecuencia.getDato().equals(doctor.getEspecialidad())) {
                    // Si la especialidad ya está en la lista, incrementar su frecuencia
                    frecuencia.incrementarFrecuencia();
                    encontrada = true;
                    break;
                }
            }
            // Si la especialidad no está en la lista, agregarla con frecuencia 1
            if (!encontrada) {
                frecuencias.add(new Frecuencia(doctor.getEspecialidad(), 1));
            }
        }
        ordenarFrecuenciasDescendente(frecuencias);
        // Devolver la lista de frecuencias
        return frecuencias;
    }

    public void ordenarFrecuenciasDescendente(ArrayList<Frecuencia> frecuencias) {
        // Definir un comparador personalizado para ordenar las frecuencias por valor de manera descendente
        Comparator<Frecuencia> comparador = new Comparator<Frecuencia>() {
            @Override
            public int compare(Frecuencia f1, Frecuencia f2) {
                // Ordenar de manera descendente por valor de frecuencia
                return Integer.compare(f2.getFrecuencia(), f1.getFrecuencia());
            }
        };

        // Ordenar la lista de frecuencias usando el comparador
        Collections.sort(frecuencias, comparador);
    }
    
    public ArrayList<Doctor> buscar_Doctor_Especialidad(String especialidad) {
        ArrayList<Doctor> doctoresEncontrados = new ArrayList<>();
        for (Doctor doctor : lista_Doctores) {
            if (doctor.getEspecialidad().equalsIgnoreCase(especialidad)) {
                doctoresEncontrados.add(doctor);
            }
        }
        return doctoresEncontrados;
    }
    
    public ArrayList<Doctor> get_Lista_Doctores(){
        return lista_Doctores;
    }
    
    public ArrayList<Paciente> get_Lista_Pacietes(){
        return lista_Pacientes;
    }
    
    public int get_id_Persona_Logueada(){
        return id_Persona_Logueada;
    }
    
    public void asignar_Cita(Cita cita_Nueva){
        int contador = 0;
        for( Doctor doctor: lista_Doctores ){
            if(doctor.getid() == cita_Nueva.getId_Doctor()){
                lista_Doctores.get(contador).agregarCita(cita_Nueva);
                break;
            }
            contador ++;
        }
        contador = 0;
        for( Paciente paciente: lista_Pacientes ){
            if( paciente.getid() == cita_Nueva.getId_Paciente() ){
                lista_Pacientes.get(contador).agregarCita(cita_Nueva);
                break;
            }
            contador ++;
        }
    }
    
    public void cambiar_Estado_Cita(String estado_Nuevo, int id_Doctor, int id_Paciente, int id_Cita){
        Cita_Controller cita_Controller = new Cita_Controller();
        
        for(Doctor doctor: lista_Doctores){
            if(doctor.getid() == id_Doctor){
                doctor.citas = cita_Controller.actualizar_Lista_Citas(id_Cita, doctor.getCitas(), estado_Nuevo, "Doctor");
                break;
            }
            
        }
        
        for(Paciente paciente: lista_Pacientes){
            if(paciente.getid() == id_Paciente){
                paciente.citas = cita_Controller.actualizar_Lista_Citas(id_Cita, paciente.getCitas(), estado_Nuevo, "Paciente");
                break;            
            }
        }
    }
    
    public void agregar_Horario(String horario){
        int id_Doc = get_id_Persona_Logueada();
        int contador = 0;
        for(Doctor doctor: lista_Doctores){
            if(doctor.getid() == id_Doc){
                lista_Doctores.get(contador).agregarHorario(horario);
            }
            contador++;
        }
    }
}