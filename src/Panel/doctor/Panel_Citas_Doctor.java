
package Panel.doctor;

import Models.Cita;
import Models.Doctor;
import Models.Paciente;
import controller.Persona_Controller;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Panel_Citas_Doctor extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lbl_Nombre_Paciente;
    private javax.swing.JLabel lbl_Hora_Cita;
    private javax.swing.JLabel lbl_Fecha_Cita;
    private javax.swing.JTextField txt_Nombre_Paciente;
    private javax.swing.JTextField txt_Hora_Cita;
    private javax.swing.JTextField txt_Fecha_Cita;
    private javax.swing.JButton btn_Ver_Mas;
    private javax.swing.JButton btn_Atender;
    private javax.swing.JButton btn_Rechazar;
    private javax.swing.JLabel lbl_Codigo_Cita;
    private javax.swing.JComboBox<String> cmb_Codigo_Cita;
    private Doctor doctor;
    private DefaultComboBoxModel<String> model;
    private Cita cita_Selec;
    private Paciente paciente_Selec;
    private Persona_Controller persona_Controller = new Persona_Controller();
    
    public Panel_Citas_Doctor(){
        initComponents();
        bloquear_Botones(false);
    }
    
    private void initComponents(){
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        lbl_Nombre_Paciente = new javax.swing.JLabel();
        lbl_Hora_Cita = new javax.swing.JLabel();
        lbl_Fecha_Cita = new javax.swing.JLabel();
        btn_Ver_Mas = new javax.swing.JButton("Ver Más");
        btn_Atender = new javax.swing.JButton("Atender");
        btn_Rechazar = new javax.swing.JButton("Rechazar");
        txt_Nombre_Paciente = new javax.swing.JTextField();
        txt_Hora_Cita = new javax.swing.JTextField();
        txt_Fecha_Cita = new javax.swing.JTextField();
        lbl_Codigo_Cita = new javax.swing.JLabel();
        cmb_Codigo_Cita = new javax.swing.JComboBox<>();
        
        txt_Nombre_Paciente.setEditable(false);
        txt_Hora_Cita.setEditable(false);
        txt_Fecha_Cita.setEditable(false);
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Información de Cita");
        titulo.setBounds(270, 30, 300, 30);
        this.add(titulo);
        
        lbl_Codigo_Cita.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Codigo_Cita.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Codigo_Cita.setText("listado de citas:");
        lbl_Codigo_Cita.setBounds(115, 100, 150, 25);
        this.add(lbl_Codigo_Cita);
        
        cmb_Codigo_Cita.setBounds(280, 100, 150, 25);
        cmb_Codigo_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Codigo_CitaActionPerformed(evt);
            }
        });
        this.add(cmb_Codigo_Cita);
        
        lbl_Nombre_Paciente.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Nombre_Paciente.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Nombre_Paciente.setText("Nombre Paciente:");
        lbl_Nombre_Paciente.setBounds(115, 150, 150, 25);
        this.add(lbl_Nombre_Paciente);
        
        txt_Nombre_Paciente.setBounds(280, 150, 150, 25);
        this.add(txt_Nombre_Paciente);
        
        lbl_Hora_Cita.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Hora_Cita.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Hora_Cita.setText("Hora Cita:");
        lbl_Hora_Cita.setBounds(115, 200, 150, 25);
        this.add(lbl_Hora_Cita);
        
        txt_Hora_Cita.setBounds(280, 200, 150, 25);
        this.add(txt_Hora_Cita);
        
        lbl_Fecha_Cita.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Fecha_Cita.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Fecha_Cita.setText("Fecha Cita:");
        lbl_Fecha_Cita.setBounds(115, 250, 150, 25);
        this.add(lbl_Fecha_Cita);
        
        txt_Fecha_Cita.setBounds(280, 250, 150, 25);
        this.add(txt_Fecha_Cita);
        
        btn_Ver_Mas.setBounds(150, 350, 100, 30);
        btn_Ver_Mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ver_MasActionPerformed(evt);
            }
        });
        this.add(btn_Ver_Mas);
        
        btn_Atender.setBounds(265, 350, 100, 30);
        btn_Atender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtenderActionPerformed(evt);
            }
        });
        this.add(btn_Atender);
        
        btn_Rechazar.setBounds(380, 350, 100, 30);
        btn_Rechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RechazarActionPerformed(evt);
            }
        });
        
        this.add(btn_Rechazar);
        
        cargar_Citas();
        setBackground(new Color(240, 240, 240));
    }
    
    private void btn_Ver_MasActionPerformed(java.awt.event.ActionEvent evt) {
        String mensaje = ("Informacion Detallada Sobre La Cita " +cita_Selec.getId()+"\n" + "Hora: " + cita_Selec.getHorario() + "\n"
                + "Fecha: " + cita_Selec.getFecha() + "\n"
                + "Paciente: " + paciente_Selec.getNombre() + " " + paciente_Selec.getApellido()+ "\n"
                + "Motivo de la cita: " + cita_Selec.getMotivo() + "\n"
                + "Estado " + cita_Selec.getEstado_Cita());
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    private void btn_AtenderActionPerformed(java.awt.event.ActionEvent evt) {
        int id_Cita = Integer.parseInt(cmb_Codigo_Cita.getSelectedItem().toString());
        persona_Controller.cambiar_Estado_Cita("Aceptado", doctor.getid(),
                paciente_Selec.getid(), id_Cita);
        JOptionPane.showMessageDialog(null, "El estado de la cita ha sido actualizado con exito");
        cargar_Citas();
    }
    
    private void btn_RechazarActionPerformed(java.awt.event.ActionEvent evt) {
        // Acción para el botón "Rechazar"
        int id_Cita = Integer.parseInt(cmb_Codigo_Cita.getSelectedItem().toString());
        persona_Controller.cambiar_Estado_Cita("Rechazado", doctor.getid(),
                paciente_Selec.getid(), id_Cita);
        JOptionPane.showMessageDialog(null, "El estado de la cita ha sido actualizado con exito");
        cargar_Citas();
    }
    
    private void cargar_Citas(){
        Persona_Controller persona = new Persona_Controller();
        model = new DefaultComboBoxModel<>();
        doctor = (Doctor)persona.buscar_Persona(persona.get_id_Persona_Logueada(), "Doctor");
        if( doctor.getCitas().size() == 0 ){
            model.addElement("No tienes citas");
            bloquear_Botones(true);
            txt_Fecha_Cita.setText("");
            txt_Hora_Cita.setText("");
            txt_Nombre_Paciente.setText("");
            bloquear_Botones(false);
        }else{
            for(Cita cita: doctor.getCitas()){
                model.addElement(String.valueOf(cita.getId()));
            }
        }
        cmb_Codigo_Cita.setModel(model);
    }
    
    private void bloquear_Botones(boolean X){
        btn_Atender.setEnabled(X);
        btn_Rechazar.setEnabled(X);
        btn_Ver_Mas.setEnabled(X);
    }
    
    private void cmb_Codigo_CitaActionPerformed(java.awt.event.ActionEvent evt){
        int codigo_Selec = Integer.valueOf(cmb_Codigo_Cita.getSelectedItem().toString());
        for( Cita cita: doctor.getCitas() ){
            if( cita.getId() ==  codigo_Selec){
                cita_Selec = cita;
                paciente_Selec = (Paciente)persona_Controller.buscar_Persona(cita.getId_Paciente(), "Paciente");
                String nombre = paciente_Selec.getNombre();
                txt_Nombre_Paciente.setText(nombre);
                txt_Hora_Cita.setText(cita.getHorario());
                txt_Fecha_Cita.setText(cita.getFecha());
                bloquear_Botones(true);
                break;
            }
        }
    }
}

