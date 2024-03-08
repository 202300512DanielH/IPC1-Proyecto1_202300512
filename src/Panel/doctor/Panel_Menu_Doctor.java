
package Panel.doctor;

import Models.Doctor;
import controller.Panel_Controller;
import controller.Persona_Controller;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

public class Panel_Menu_Doctor extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton btn_Citas;
    private javax.swing.JButton btn_Asignar_Horario;
    private javax.swing.JButton btn_Cerrar_Sesion;
    private javax.swing.JButton btn_Editar_Perfil;
    private javax.swing.JPanel panel_Transicion;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JTable tabla;
    private DefaultTableModel modeloTabla;
    private Persona_Controller persona_Controller = new Persona_Controller();
    
    public Panel_Menu_Doctor(){
        initComponents();
    }    
    
    private void initComponents(){
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        btn_Citas = new javax.swing.JButton("Citas");
        btn_Asignar_Horario = new javax.swing.JButton("Asignar Horario");
        btn_Cerrar_Sesion = new javax.swing.JButton("Cerrar Sesión");
        btn_Editar_Perfil = new javax.swing.JButton("Editar Perfil");
        panel_Transicion = new javax.swing.JPanel();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Menú Principal - Doctor");
        titulo.setBounds(300, 30, 300, 30);
        this.add(titulo);
        
        int buttonWidth = 140;
        int buttonHeight = 40;
        int initialX = 50;
        int initialY = 100;  // Cambiada la coordenada Y inicial
        int horizontalSpacing = 150;  // Espacio vertical entre botones
        
        btn_Citas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Citas.setForeground(new java.awt.Color(0, 0, 0));
        btn_Citas.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CitasActionPerformed(evt);
            }
        });
        add(btn_Citas);
        initialX += horizontalSpacing;  // Aumenta la coordenada Y para el siguiente botón

        
        btn_Asignar_Horario.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Asignar_Horario.setForeground(new java.awt.Color(0, 0, 0));
        btn_Asignar_Horario.setBounds(initialX, initialY, buttonWidth+20, buttonHeight);
        btn_Asignar_Horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Asignar_HorarioActionPerformed(evt);
            }
        });
        add(btn_Asignar_Horario);
        initialX += 415;  // Aumenta la coordenada Y para el siguiente botón

        
        btn_Editar_Perfil.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Editar_Perfil.setForeground(new java.awt.Color(0, 0, 0));
        btn_Editar_Perfil.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Editar_Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Editar_PerfilActionPerformed(evt);
            }
        });
        add(btn_Editar_Perfil);
        
        btn_Cerrar_Sesion.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Cerrar_Sesion.setForeground(new java.awt.Color(0, 0, 0));
        btn_Cerrar_Sesion.setBounds(600, 610, 150, buttonHeight);
        btn_Cerrar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cerrar_SesionActionPerformed(evt);
            }
        });
        add(btn_Cerrar_Sesion);
        
        panel_Transicion.setBounds(50,150,710,430);
        panel_Transicion.setBackground(new java.awt.Color(250,220,184));
        this.add(panel_Transicion);
        
        setBackground(new java.awt.Color(168,204,241));
    }
    
    private void btn_Editar_PerfilActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Perfil_Doctor();
        cambiarPaneles(panelFind);
    }
    
    public void cambiarPaneles(javax.swing.JPanel miPanel){
        miPanel.setSize(708, 428); //Ancho y alto de los paneles colocados en la ventana
        miPanel.setLocation(0, 0); //Colocado en la posicion superior izquierda de la ventana
        panel_Transicion.removeAll();
        panel_Transicion.setLayout(new BorderLayout());
        panel_Transicion.add(miPanel, BorderLayout.CENTER);
        panel_Transicion.revalidate();
        panel_Transicion.repaint();
    }
    
    private void btn_Cerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Login();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
    private void btn_CitasActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Citas_Doc();
        cambiarPaneles(panelFind);
    }
    
    private void btn_Asignar_HorarioActionPerformed(java.awt.event.ActionEvent evt) {
        generar_Panel_Horarios();
        cargar_Datos();
    }
    
    private void generar_Panel_Horarios(){
        panel_Transicion.removeAll();
        panel_Transicion.revalidate();
        panel_Transicion.repaint();
        panel_Transicion.setLayout(null);
        
        titulo = new javax.swing.JLabel("Horarios");
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setBounds(300, 20, 100, 30);
        panel_Transicion.add(titulo);
        
        lblHorario = new javax.swing.JLabel("Horario de Citas:");
        lblHorario.setBounds(50, 80, 120, 25);
        panel_Transicion.add(lblHorario);

        txtHorario = new javax.swing.JTextField();
        txtHorario.setBounds(180, 80, 120, 25);
        panel_Transicion.add(txtHorario);

        btnAgregar = new javax.swing.JButton("Agregar");
        btnAgregar.setBounds(320, 80, 100, 25);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panel_Transicion.add(btnAgregar);
        
        modeloTabla = new DefaultTableModel();
        tabla = new javax.swing.JTable(modeloTabla);
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tabla);
        scrollPane.setBounds(50, 150, 600, 200);
        panel_Transicion.add(scrollPane);
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        String horario = txtHorario.getText();
        persona_Controller.agregar_Horario(horario);
        cargar_Datos();
    }
    
    private void cargar_Datos(){
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnIdentifiers(new Object[]{"No", "Horaro de Cita"});
        tabla.setModel(modeloTabla);
        int id = persona_Controller.get_id_Persona_Logueada();
        Doctor doctor = (Doctor) persona_Controller.buscar_Persona(id, "Doctor");
        int cont = 1;
        for(String horario: doctor.getHorarios()){
            modeloTabla.addRow(new Object[]{cont, horario});
            cont++;
        }
    }
}
