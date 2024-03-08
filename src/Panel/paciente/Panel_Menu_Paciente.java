
package Panel.paciente;

import Models.Cita;
import Models.Paciente;
import Models.Producto;
import controller.Panel_Controller;
import controller.Persona_Controller;
import controller.Productos_Controller;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Panel_Menu_Paciente extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton btn_Solicitar_Citas;
    private javax.swing.JButton btn_Estado_Citas;
    private javax.swing.JButton btn_Farmacia;
    private javax.swing.JButton btn_Cerrar_Sesion;
    private javax.swing.JButton btn_Editar_Perfil;
    private javax.swing.JPanel panel_Transicion;
    private DefaultTableModel model = new DefaultTableModel();
    public javax.swing.JTable tbl_Base;
    private javax.swing.JScrollPane jScrollPane1;
    private ArrayList<Producto> lista_Productos;
    private Persona_Controller persona_Controller = new Persona_Controller();
            
    public Panel_Menu_Paciente(){
        initComponents();
        Productos_Controller productos = new Productos_Controller();
        lista_Productos = productos.get_Lista_Productos();
    }
    
    private void initComponents(){
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        btn_Solicitar_Citas = new javax.swing.JButton("Solicitar Citas");
        btn_Estado_Citas = new javax.swing.JButton("Estado Citas");
        btn_Farmacia = new javax.swing.JButton("Farmacia");
        btn_Cerrar_Sesion = new javax.swing.JButton("Cerrar Sesión");
        btn_Editar_Perfil = new javax.swing.JButton("Editar Perfil");
        panel_Transicion = new javax.swing.JPanel();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Menú Principal - Paciente");
        titulo.setBounds(270, 30, 300, 30);
        this.add(titulo);
        
        int buttonWidth = 140;
        int buttonHeight = 40;
        int initialX = 50;
        int initialY = 100;  // Cambiada la coordenada Y inicial
        int horizontalSpacing = 150;  // Espacio vertical entre botones
        
        btn_Solicitar_Citas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Solicitar_Citas.setForeground(new java.awt.Color(0, 0, 0));
        btn_Solicitar_Citas.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Solicitar_Citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Solicitar_CitasActionPerformed(evt);
            }
        });
        add(btn_Solicitar_Citas);
        initialX += horizontalSpacing;  // Aumenta la coordenada Y para el siguiente botón
        
        btn_Estado_Citas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Estado_Citas.setForeground(new java.awt.Color(0, 0, 0));
        btn_Estado_Citas.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Estado_Citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Estado_CitasActionPerformed(evt);
            }
        });
        add(btn_Estado_Citas);
        initialX += horizontalSpacing;  // Aumenta la coordenada Y para el siguiente botón

        
        btn_Farmacia.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Farmacia.setForeground(new java.awt.Color(0, 0, 0));
        btn_Farmacia.setBounds(initialX, initialY, buttonWidth, buttonHeight);
        btn_Farmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FarmaciaActionPerformed(evt);
            }
        });
        add(btn_Farmacia);
        initialX += 270;  // Aumenta la coordenada Y para el siguiente botón

        
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
    
    private void btn_Cerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Login();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
    private void btn_Solicitar_CitasActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Crear_Citas();
        cambiarPaneles(panelFind);
    }
    
    private void btn_Estado_CitasActionPerformed(java.awt.event.ActionEvent evt) {
        mostrar_Tabla("Historial Sobre Citas");
        cargar_Datos_Citas();
    }
    
    private void btn_FarmaciaActionPerformed(java.awt.event.ActionEvent evt) {
        mostrar_Tabla("Productos En Farmacia");
        cargar_Datos_Tabla();
    }
    
    private void btn_Editar_PerfilActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Perfil();
        cambiarPaneles(panelFind);
    }
    
    public void mostrar_Tabla(String encabezado){
        panel_Transicion.removeAll();
        panel_Transicion.revalidate();
        panel_Transicion.repaint();
        panel_Transicion.setLayout(null);
        
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Base = new javax.swing.JTable();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText(encabezado);
        titulo.setBounds(270, 30, 300, 30);
        panel_Transicion.add(titulo);
        
        // Configurar la tabla
        tbl_Base.setModel(model);
        tbl_Base.setEnabled(false);
        jScrollPane1.setViewportView(tbl_Base);
        int x = 80;
        int y = 100;
        int width = 550;
        int height = 250;
        
        // Establecer la posición y tamaño del JScrollPane
        jScrollPane1.setBounds(x, y, width, height);
        // Añadir el JScrollPane al panel
        panel_Transicion.add(jScrollPane1);
    }
    
    public void cargar_Datos_Tabla(){
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"Nombre", "Descripcion","Precio"});
        tbl_Base.setModel(model);
        for( Producto producto: lista_Productos ){
            model.addRow(new Object[]{producto.getNombre(), producto.getDescripcion(), producto.getPrecio()});
        }
    }
    
    public void cargar_Datos_Citas(){
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"No", "Estado","Fecha","Hora"});
        int id = persona_Controller.get_id_Persona_Logueada();
        Paciente persona_Log = (Paciente) persona_Controller.buscar_Persona(id, "Paciente");
        tbl_Base.setModel(model);
        for( Cita citas_Paciente: persona_Log.getCitas() ){
            model.addRow(new Object[]{citas_Paciente.getId(),citas_Paciente.getEstado_Cita(),
                citas_Paciente.getFecha(), citas_Paciente.getHorario()});
        }
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
}
