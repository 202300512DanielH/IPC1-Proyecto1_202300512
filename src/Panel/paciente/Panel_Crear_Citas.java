
package Panel.paciente;

import Models.Cita;
import Models.Doctor;
import Models.Frecuencia;
import Models.Paciente;
import controller.Cita_Controller;
import controller.Persona_Controller;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_Crear_Citas extends javax.swing.JPanel{
    
    private Persona_Controller persona_Controller = new Persona_Controller();
    private ArrayList<Doctor> lista_Doctores;
    private JLabel lblEspecialidad;
    private JLabel lblDoctor;
    private JLabel lblMotivoCita;
    private JLabel lblHorarioCitas;
    private JLabel lblFecha;
    private JLabel lblHora;
    private JButton btnGenerarCita;
    private JButton btnMostrarDoctores;
    private JButton btnMostrarHorarios;
    private JComboBox<String> cmbEspecialidad;
    private JComboBox<String> cmbDoctor;
    private JComboBox<String> cmbHora;
    private JTextArea txtMotivoCita;
    private JTextField fecha;

    public Panel_Crear_Citas() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        lblMotivoCita = new JLabel("Motivo de la Cita:");
        lblMotivoCita.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblMotivoCita.setBounds(10, 20, 150, 20);
        add(lblMotivoCita);

        txtMotivoCita = new JTextArea();
        txtMotivoCita.setBounds(10, 40, 650, 100);
        add(txtMotivoCita);

        lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(50, 160, 100, 20);
        add(lblEspecialidad);

        cmbEspecialidad = new JComboBox<>();
        cmbEspecialidad.setBounds(160, 160, 200, 25);
        cargar_Especialidades();
        add(cmbEspecialidad);
        
        btnMostrarDoctores = new JButton("Mostrar Doctores");
        btnMostrarDoctores.setBounds(380, 160, 150, 30);
        btnMostrarDoctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDoctoresActionPerformed(evt);
            }
        });
        add(btnMostrarDoctores);

        lblDoctor = new JLabel("Doctor:");
        lblDoctor.setBounds(50, 200, 100, 20);
        add(lblDoctor);

        cmbDoctor = new JComboBox<>();
        cmbDoctor.setBounds(160, 200, 200, 25);
        add(cmbDoctor);
        
        btnMostrarHorarios = new JButton("Mostrar Doctores");
        btnMostrarHorarios.setBounds(380, 200, 150, 30);
        btnMostrarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarHorariosActionPerformed(evt);
            }
        });
        add(btnMostrarHorarios);

        lblHorarioCitas = new JLabel("Horario de Citas:");
        lblHorarioCitas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblHorarioCitas.setBounds(50, 250, 150, 20);
        add(lblHorarioCitas);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(50, 300, 80, 20);
        add(lblFecha);

        fecha = new JTextField();
        fecha.setBounds(150, 300, 150, 25);
        add(fecha);

        lblHora = new JLabel("Hora:");
        lblHora.setBounds(320, 300, 80, 20);
        add(lblHora);

        cmbHora = new JComboBox<>();
        cmbHora.setBounds(420, 300, 150, 20);
        add(cmbHora);

        btnGenerarCita = new JButton("Generar Cita");
        btnGenerarCita.setBounds(500, 380, 150, 30);
        btnGenerarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCitaActionPerformed(evt);
            }
        });
        
        
        int id = persona_Controller.get_id_Persona_Logueada();
        Paciente persona_Log = (Paciente) persona_Controller.buscar_Persona(id, "Paciente");
        if( persona_Log.getCitas().size() != 0){
            int cod = persona_Log.getCitas().size() - 1;
            Cita cita_Final = persona_Log.getCitas().get(cod);
            if( cita_Final.getEstado_Cita().equals("Pendiente") ){
                btnGenerarCita.setEnabled(false);
            }
        }
        add(btnGenerarCita);

        setBackground(new Color(240, 240, 240));
    }
    
    private void btnGenerarCitaActionPerformed(java.awt.event.ActionEvent evt) {
        // Funcionalidad para el botón Generar Cita
        String nombre = (String) cmbDoctor.getSelectedItem();
        int contador = 0;
        for( Doctor doctor: lista_Doctores ){
            if( doctor.getNombre().equalsIgnoreCase(nombre) ){
                Doctor encontrado = (Doctor) persona_Controller.buscar_Persona(doctor.getid(), "Doctor");
                Cita_Controller cita_Controller = new Cita_Controller();
                int id_Doctor = encontrado.getid();
                int id_Paciente = persona_Controller.get_id_Persona_Logueada();
                String horario = (String) cmbHora.getSelectedItem();
                String fecha_Cita = fecha.getText();
                String motivo = txtMotivoCita.getText();
                Cita cita_Nueva = cita_Controller.generar_Cita(id_Doctor, id_Paciente, horario, fecha_Cita, motivo);                
                persona_Controller.asignar_Cita(cita_Nueva);
                btnGenerarCita.setEnabled(false);
                JOptionPane.showMessageDialog(null, "La cita se ha creado correctamente");
                break;
            }
            contador++;
        }
    }
    
    private void btnMostrarDoctoresActionPerformed(java.awt.event.ActionEvent evt) {
        // Funcionalidad para el botón MostrarDoctores
        String especialidad = (String) cmbEspecialidad.getSelectedItem();
        lista_Doctores = persona_Controller.buscar_Doctor_Especialidad(especialidad);
        cmbDoctor.removeAllItems();
        for ( Doctor doctor: lista_Doctores ){
            cmbDoctor.addItem(doctor.getNombre());
        }
    }
    
    private void btnMostrarHorariosActionPerformed(java.awt.event.ActionEvent evt){
        int contador = 0;
        String nombre_Doctor =  (String)cmbDoctor.getSelectedItem();
        for( Doctor doctor: lista_Doctores ){
            if( doctor.getNombre() == lista_Doctores.get(contador).getNombre()){
                cargar_Horarios(doctor.getHorarios());
                break;
            }
            contador++;
        }
    }
    
    private void cargar_Horarios(ArrayList<String> horarios){
        cmbHora.removeAllItems();
        for( String horario: horarios ){
            cmbHora.addItem(horario);
        }
    }
    
    private void cargar_Especialidades(){
        ArrayList<Frecuencia> lista_Especialidades = persona_Controller.registrarFrecuenciaEspecialidad();
        for( Frecuencia frecuencia: lista_Especialidades ){
            cmbEspecialidad.addItem(frecuencia.getDato());
        }
    }
    
    
}
