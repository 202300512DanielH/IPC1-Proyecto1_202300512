
package Panel.administrador;

import Models.Paciente;
import controller.Panel_Controller;
import controller.Persona_Controller;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Panel_Control_Pacientes extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;   
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lbl_Nombres;
    private javax.swing.JLabel lbl_Apellidos;
    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_Genero;
    private javax.swing.JLabel lbl_Edad;
    private javax.swing.JTextField txt_Nombres;
    private javax.swing.JTextField txt_Apellidos;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JComboBox<String> cmb_Genero;
    private javax.swing.JTextField txt_Edad;
    private javax.swing.JButton btn_Registrarse;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Aceptar_Cambios;
    private javax.swing.JButton btn_Cancelar_Cambios;
    private int codigo;
    
    public Panel_Control_Pacientes(){
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        lbl_Nombres = new javax.swing.JLabel();
        lbl_Apellidos = new javax.swing.JLabel();
        lbl_Password = new javax.swing.JLabel();
        lbl_Genero = new javax.swing.JLabel();
        lbl_Edad = new javax.swing.JLabel();
        txt_Nombres = new javax.swing.JTextField();
        txt_Apellidos = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        cmb_Genero = new javax.swing.JComboBox<>();
        txt_Edad = new javax.swing.JTextField();
        btn_Registrarse = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Aceptar_Cambios = new javax.swing.JButton();
        btn_Cancelar_Cambios = new javax.swing.JButton();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Acciones Pacientes");
        titulo.setBounds(250, 25, 320, 30);
        this.add(titulo);
        
        lbl_Nombres.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Nombres.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Nombres.setText("Nombres:");
        lbl_Nombres.setBounds(50, 100, 80, 25);
        this.add(lbl_Nombres);
        
        lbl_Apellidos.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Apellidos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Apellidos.setText("Apellidos:");
        lbl_Apellidos.setBounds(50, 150, 80, 25);
        this.add(lbl_Apellidos);
        
        lbl_Password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Password.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Password.setText("Contraseña:");
        lbl_Password.setBounds(50, 200, 80, 25);
        this.add(lbl_Password);
        
        lbl_Genero.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Genero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Genero.setText("Género:");
        lbl_Genero.setBounds(380, 100, 80, 25);
        this.add(lbl_Genero);
        
        lbl_Edad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Edad.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Edad.setText("Edad:");
        lbl_Edad.setBounds(380, 150, 80, 25);
        this.add(lbl_Edad);
        
        txt_Nombres.setBounds(150, 100, 200, 25);
        this.add(txt_Nombres);
        
        txt_Apellidos.setBounds(150, 150, 200, 25);
        this.add(txt_Apellidos);
        
        txt_Password.setBounds(150, 200, 200, 25);
        this.add(txt_Password);
        
        cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmb_Genero.setBounds(450, 100, 200, 25);
        this.add(cmb_Genero);
        
        txt_Edad.setBounds(450, 150, 200, 25);
        this.add(txt_Edad);
        
        btn_Registrarse.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Registrarse.setForeground(new java.awt.Color(0, 0, 0));
        btn_Registrarse.setText("Crear Cuenta");
        btn_Registrarse.setBounds(50, 350, 150, 30);
        btn_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarseActionPerformed(evt);
            }
        });
        this.add(btn_Registrarse);
        
        btn_Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.setBounds(220, 350, 150, 30);
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        this.add(btn_Actualizar);
        
        btn_Eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setBounds(390, 350, 150, 30);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        this.add(btn_Eliminar);
        
        btn_Aceptar_Cambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Aceptar_Cambios.setText("Actualizar");
        btn_Aceptar_Cambios.setBounds(50, 300, 150, 30);
        btn_Aceptar_Cambios.setBackground(new java.awt.Color(0, 153, 51)); // Color rojo
        btn_Aceptar_Cambios.setVisible(false);
        btn_Aceptar_Cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Aceptar_CambiosActionPerformed(evt);
            }
        });
        this.add(btn_Aceptar_Cambios);
        
        btn_Cancelar_Cambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Cancelar_Cambios.setText("Cancelar");
        btn_Cancelar_Cambios.setBounds(220, 300, 150, 30);
        btn_Cancelar_Cambios.setBackground(new java.awt.Color(255, 0, 0)); // Color azul
        btn_Cancelar_Cambios.setVisible(false);
        btn_Cancelar_Cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar_CambiosActionPerformed(evt);
            }
        });
        this.add(btn_Cancelar_Cambios);
        
        setBackground(new java.awt.Color(210,242,238));
    }
    
    private void btn_RegistrarseActionPerformed(java.awt.event.ActionEvent evt){
        try {
            int edad = Integer.parseInt(txt_Edad.getText());
            String nombres = txt_Nombres.getText();
            String apellidos = txt_Apellidos.getText();
            String sexo = cmb_Genero.getSelectedItem().toString();
            String password = txt_Password.getText();
            
            Persona_Controller persona_Controller = new Persona_Controller();
            persona_Controller.Registrarse(nombres, apellidos, password, edad, sexo);
            Panel_Controller panel_Controller = new Panel_Controller();
            panelFind = panel_Controller.get_Panel_Menu_Administrador();
            panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La edad debe ser numeros enteros");            
        }
    }
    
    private void regresar(){
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Menu_Administrador();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt){
        // Mostrar un cuadro de diálogo de entrada para que el usuario ingrese un código
        try{
            codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del paciente a actualizar:", "Código paciente", JOptionPane.PLAIN_MESSAGE));
            Persona_Controller persona_Controller = new Persona_Controller();
            Paciente paciente_Encontrado = (Paciente)persona_Controller.buscar_Persona(codigo,"Paciente");
            if (paciente_Encontrado != null){
                txt_Nombres.setText(paciente_Encontrado.getNombre());
                txt_Apellidos.setText(paciente_Encontrado.getApellido());
                txt_Password.setText(paciente_Encontrado.getContraseña());
                txt_Edad.setText(String.valueOf(paciente_Encontrado.getEdad()));
                cmb_Genero.setSelectedItem(paciente_Encontrado.getSexo());
                uso_Boton(false);
            }else{
                JOptionPane.showMessageDialog(null, "paciente no encontrado o no existe");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El codigo proporcionado debe ser numeros enteros");
        }
    }
    
    private void btn_Aceptar_CambiosActionPerformed(ActionEvent evt) {
        try {
            int edad = Integer.parseInt(txt_Edad.getText());
            String nombres = txt_Nombres.getText();
            String apellidos = txt_Apellidos.getText();
            String sexo = cmb_Genero.getSelectedItem().toString();
            String password = txt_Password.getText();            
            Persona_Controller persona_Controller = new Persona_Controller();
            persona_Controller.actualizar_Paciente(codigo, nombres, apellidos, password, edad, sexo);
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del paciente correctamente");
            regresar();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Edad debe ser un numero entero");
        }
    }
    
    private void btn_Cancelar_CambiosActionPerformed(ActionEvent evt) {
        txt_Nombres.setText("");
        txt_Apellidos.setText("");
        txt_Password.setText("");
        txt_Edad.setText(String.valueOf(""));
        uso_Boton(true);
    }
    
    private void uso_Boton(boolean valor){
        btn_Registrarse.setEnabled(valor);
        btn_Actualizar.setEnabled(valor);
        btn_Eliminar.setEnabled(valor);
        if(!valor){
            btn_Aceptar_Cambios.setVisible(true);
            btn_Cancelar_Cambios.setVisible(true);
        }else{
            btn_Aceptar_Cambios.setVisible(false);
            btn_Cancelar_Cambios.setVisible(false);
        }
    }
    
    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt){
        codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del paciente a eliminar:", "Código paciente", JOptionPane.PLAIN_MESSAGE));
        Persona_Controller persona_Controller = new Persona_Controller();
        boolean resultado = persona_Controller.eliminar_Persona(codigo, "Paciente");
        if(resultado){
            JOptionPane.showMessageDialog(null, "El Paciente ha sido encontrado y eliminado exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "El Paciente no ha sido encotrado o no existe");
        }
    }
}
