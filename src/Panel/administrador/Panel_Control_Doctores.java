
package Panel.administrador;

import Models.Doctor;
import controller.Panel_Controller;
import controller.Persona_Controller;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Panel_Control_Doctores extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lbl_Nombres;
    private javax.swing.JLabel lbl_Apellidos;
    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_Genero;
    private javax.swing.JLabel lbl_Especialidad;
    private javax.swing.JLabel lbl_Telefono;
    private javax.swing.JLabel lbl_Edad;
    private javax.swing.JTextField txt_Nombres;
    private javax.swing.JTextField txt_Apellidos;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JComboBox<String> cmb_Genero;
    private javax.swing.JTextField txt_Especialidad;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_Edad;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Crear_Doctor;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Aceptar_Cambios;
    private javax.swing.JButton btn_Cancelar_Cambios;
    private int codigo;
    
    public Panel_Control_Doctores(){
        initComponents();
    }
    
    private void initComponents(){
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        lbl_Nombres = new javax.swing.JLabel();
        lbl_Apellidos = new javax.swing.JLabel();
        lbl_Password = new javax.swing.JLabel();
        lbl_Genero = new javax.swing.JLabel();
        lbl_Especialidad = new javax.swing.JLabel();
        lbl_Telefono = new javax.swing.JLabel();
        lbl_Edad = new javax.swing.JLabel();
        txt_Nombres = new javax.swing.JTextField();
        txt_Apellidos = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        txt_Especialidad = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        cmb_Genero = new javax.swing.JComboBox<>();
        txt_Edad = new javax.swing.JTextField();
        btn_Regresar = new javax.swing.JButton();
        btn_Crear_Doctor = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Aceptar_Cambios = new javax.swing.JButton();
        btn_Cancelar_Cambios = new javax.swing.JButton();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Acciones Doctores - Administrador");
        titulo.setBounds(250, 50, 300, 30);
        this.add(titulo);
        
        final int lbl_txt_Height = 25;
        
        lbl_Nombres.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Nombres.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Nombres.setText("Nombres:");
        lbl_Nombres.setBounds(50, 150, 80, lbl_txt_Height);
        this.add(lbl_Nombres);
        
        txt_Nombres.setBounds(150, 150, 200, lbl_txt_Height);
        this.add(txt_Nombres);
        
        lbl_Apellidos.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Apellidos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Apellidos.setText("Apellidos:");
        lbl_Apellidos.setBounds(50, 200, 80, lbl_txt_Height);
        this.add(lbl_Apellidos);
        
        txt_Apellidos.setBounds(150, 200, 200, lbl_txt_Height);
        this.add(txt_Apellidos);
        
        lbl_Password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Password.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Password.setText("Contraseña:");
        lbl_Password.setBounds(50, 250, 80, lbl_txt_Height);
        this.add(lbl_Password);
        
        txt_Password.setBounds(150, 250, 200, lbl_txt_Height);
        this.add(txt_Password);
        
        lbl_Genero.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Genero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Genero.setText("Género:");
        lbl_Genero.setBounds(50, 300, 80, lbl_txt_Height);
        this.add(lbl_Genero);
        
        cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmb_Genero.setBounds(150, 300, 200, lbl_txt_Height);
        this.add(cmb_Genero);
        
        lbl_Especialidad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Especialidad.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Especialidad.setText("Especialidad:");
        lbl_Especialidad.setBounds(380, 150, 80, lbl_txt_Height);
        this.add(lbl_Especialidad);
        
        txt_Especialidad.setBounds(480, 150, 200, lbl_txt_Height);
        this.add(txt_Especialidad);
        
        lbl_Telefono.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Telefono.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Telefono.setText("Telefono:");
        lbl_Telefono.setBounds(380, 200, 80, lbl_txt_Height);
        this.add(lbl_Telefono);
        
        txt_Telefono.setBounds(480, 200, 200, lbl_txt_Height);
        this.add(txt_Telefono);
        
        lbl_Edad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Edad.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Edad.setText("Edad:");
        lbl_Edad.setBounds(380, 250, 80, lbl_txt_Height);
        this.add(lbl_Edad);
        
        txt_Edad.setBounds(480, 250, 200, lbl_txt_Height);
        this.add(txt_Edad);
        
        btn_Regresar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Regresar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Regresar.setText("Regresar");
        btn_Regresar.setBounds(550, 600, 150, 30);
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });
        this.add(btn_Regresar);
        
        btn_Crear_Doctor.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Crear_Doctor.setForeground(new java.awt.Color(0, 0, 0));
        btn_Crear_Doctor.setText("Crear Cuenta");
        btn_Crear_Doctor.setBounds(50, 500, 150, 30);
        btn_Crear_Doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Crear_DoctorActionPerformed(evt);
            }
        });
        this.add(btn_Crear_Doctor);
        
        btn_Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.setBounds(220, 500, 150, 30);
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        this.add(btn_Actualizar);
        
        btn_Eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setBounds(390, 500, 150, 30);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        this.add(btn_Eliminar);
        
        btn_Aceptar_Cambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Aceptar_Cambios.setForeground(new java.awt.Color(0, 0, 0));
        btn_Aceptar_Cambios.setText("Actualizar");
        btn_Aceptar_Cambios.setBounds(50, 450, 150, 30);
        btn_Aceptar_Cambios.setBackground(new java.awt.Color(0, 153, 51)); // Color rojo
        btn_Aceptar_Cambios.setVisible(false);
        btn_Aceptar_Cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Aceptar_CambiosActionPerformed(evt);
            }
        });
        this.add(btn_Aceptar_Cambios);
        
        btn_Cancelar_Cambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Cancelar_Cambios.setForeground(new java.awt.Color(0, 0, 0));
        btn_Cancelar_Cambios.setText("Cancelar");
        btn_Cancelar_Cambios.setBounds(220, 450, 150, 30);
        btn_Cancelar_Cambios.setBackground(new java.awt.Color(255, 0, 0)); // Color azul
        btn_Cancelar_Cambios.setVisible(false);
        btn_Cancelar_Cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar_CambiosActionPerformed(evt);
            }
        });
        this.add(btn_Cancelar_Cambios);
        
        setBackground(new java.awt.Color(171,255,213));
    }
    
    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {
        regresar();
    }
    
    private void btn_Crear_DoctorActionPerformed(java.awt.event.ActionEvent evt){
        try {
            int edad = Integer.parseInt(txt_Edad.getText());
            String nombres = txt_Nombres.getText();
            String apellidos = txt_Apellidos.getText();
            String sexo = cmb_Genero.getSelectedItem().toString();
            String password = txt_Password.getText();
            String especialidad = txt_Especialidad.getText();
            int telefono = Integer.parseInt(txt_Telefono.getText());
            
            Persona_Controller persona_Controller = new Persona_Controller();
            persona_Controller.Crear_Doctor(nombres, apellidos, password, edad, sexo, telefono, especialidad);
            regresar();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Edad o Telefono no son numeros enteros");            
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
            codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del doctor a actualizar:", "Código Doctor", JOptionPane.PLAIN_MESSAGE));
            Persona_Controller persona_Controller = new Persona_Controller();
            Doctor doctor_Encontrado = (Doctor)persona_Controller.buscar_Persona(codigo,"Doctor");
            if (doctor_Encontrado != null){
                txt_Nombres.setText(doctor_Encontrado.getNombre());
                txt_Apellidos.setText(doctor_Encontrado.getApellido());
                txt_Password.setText(doctor_Encontrado.getContraseña());
                txt_Especialidad.setText(doctor_Encontrado.getEspecialidad());
                txt_Telefono.setText(String.valueOf(doctor_Encontrado.getTelefono()));
                txt_Edad.setText(String.valueOf(doctor_Encontrado.getEdad()));
                cmb_Genero.setSelectedItem(doctor_Encontrado.getSexo());
                uso_Boton(false);
            }else{
                JOptionPane.showMessageDialog(null, "Doctor no encontrado o no existe");
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
            String especialidad = txt_Especialidad.getText();
            int telefono = Integer.parseInt(txt_Telefono.getText());
            
            Persona_Controller persona_Controller = new Persona_Controller();
            persona_Controller.actualizar_Doctor(codigo, nombres, apellidos, password, edad, sexo, telefono, especialidad);
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del doctor correctamente");
            regresar();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Edad o Telefono no son numeros enteros");
        }
    }
    
    private void btn_Cancelar_CambiosActionPerformed(ActionEvent evt) {
        txt_Nombres.setText("");
        txt_Apellidos.setText("");
        txt_Password.setText("");
        txt_Especialidad.setText("");
        txt_Telefono.setText(String.valueOf(""));
        txt_Edad.setText(String.valueOf(""));
        uso_Boton(true);
    }
    
    private void uso_Boton(boolean valor){
        btn_Crear_Doctor.setEnabled(valor);
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
        codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del doctor a eliminar:", "Código Doctor", JOptionPane.PLAIN_MESSAGE));
        Persona_Controller persona_Controller = new Persona_Controller();
        boolean resultado = persona_Controller.eliminar_Persona(codigo, "Doctor");
        if(resultado){
            JOptionPane.showMessageDialog(null, "El doctor ha sido encontrado y eliminado exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "El doctor no ha sido encotrado o no existe");
        }
    }
}
