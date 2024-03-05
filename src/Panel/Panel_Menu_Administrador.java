
package Panel;

import controller.Panel_Controller;

public class Panel_Menu_Administrador extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton btn_Administrar_Doctores;
    private javax.swing.JButton btn_Administrar_Pacientes;
    private javax.swing.JButton btn_Administrar_Productos;
    private javax.swing.JButton btn_Reportes;
    private javax.swing.JButton btn_Cerrar_Sesion;
    private javax.swing.JPanel panel_Centro;
    
    public Panel_Menu_Administrador(){
        initComponents();
    }
    
    private void initComponents(){
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        btn_Administrar_Doctores = new javax.swing.JButton("Doctores");
        btn_Administrar_Pacientes = new javax.swing.JButton("Pacientes");
        btn_Administrar_Productos = new javax.swing.JButton("Productos");
        btn_Cerrar_Sesion = new javax.swing.JButton("Cerrar Sesión");
        btn_Reportes = new javax.swing.JButton("Reportes");
        panel_Centro = new javax.swing.JPanel();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Menú Principal - Administrador");
        titulo.setBounds(250, 30, 300, 30);
        this.add(titulo);
        
        int buttonWidth = 140;
        int buttonHeight = 40;
        int initialX = 320;
        int initialY = 200;  // Cambiada la coordenada Y inicial
        int verticalSpacing = 50;  // Espacio vertical entre botones
        
        btn_Administrar_Doctores.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Administrar_Doctores.setForeground(new java.awt.Color(0, 0, 0));
        btn_Administrar_Doctores.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Administrar_Doctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Administrar_DoctoresActionPerformed(evt);
            }
        });
        add(btn_Administrar_Doctores);
        initialY += verticalSpacing;  // Aumenta la coordenada Y para el siguiente botón

        
        btn_Administrar_Pacientes.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Administrar_Pacientes.setForeground(new java.awt.Color(0, 0, 0));
        btn_Administrar_Pacientes.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Administrar_Pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Administrar_PacientesActionPerformed(evt);
            }
        });
        add(btn_Administrar_Pacientes);
        initialY += verticalSpacing;  // Aumenta la coordenada Y para el siguiente botón

        
        btn_Administrar_Productos.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Administrar_Productos.setForeground(new java.awt.Color(0, 0, 0));
        btn_Administrar_Productos.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Administrar_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Administrar_ProductosActionPerformed(evt);
            }
        });
        add(btn_Administrar_Productos);
        initialY += verticalSpacing;  // Aumenta la coordenada Y para el siguiente botón

        
        btn_Reportes.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Reportes.setForeground(new java.awt.Color(0, 0, 0));
        btn_Reportes.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportesActionPerformed(evt);
            }
        });
        add(btn_Reportes);
        initialY += verticalSpacing;  // Aumenta la coordenada Y para el siguiente botón
        
        btn_Cerrar_Sesion.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Cerrar_Sesion.setForeground(new java.awt.Color(0, 0, 0));
        btn_Cerrar_Sesion.setBounds(550, 600, 150, buttonHeight);
        btn_Cerrar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cerrar_SesionActionPerformed(evt);
            }
        });
        add(btn_Cerrar_Sesion);
        
        setBackground(new java.awt.Color(168,204,241));
    }
    
    private void btn_Administrar_DoctoresActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Control_Doctores();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
    private void btn_Administrar_PacientesActionPerformed(java.awt.event.ActionEvent evt) {
        // Lógica para administrar pacientes
    }
    
    private void btn_Administrar_ProductosActionPerformed(java.awt.event.ActionEvent evt) {
        // Lógica para administrar productos
    }
    
    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {
        // Lógica para generar reportes
    }
    
    private void btn_Cerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Login();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
}
