
package Panel.doctor;

import Models.Doctor;
import controller.Persona_Controller;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Panel_Perfil_Doctor extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private Doctor doctor;
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
    private javax.swing.JButton btn_Actualizar;
    
    public Panel_Perfil_Doctor(){
        initComponents();
    }
    
    public void initComponents(){
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
        cmb_Genero = new javax.swing.JComboBox<>();
        txt_Edad = new javax.swing.JTextField();
        txt_Especialidad = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        btn_Actualizar = new javax.swing.JButton();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Perfil Del Doctor");
        titulo.setBounds(300, 50, 300, 30);
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
        lbl_Especialidad.setBounds(380, 150, 100, lbl_txt_Height);
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
        
        btn_Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.setBounds(500, 350, 150, 30);
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        cargar_Datos_Perfil();
        this.add(btn_Actualizar);
        
        cargar_Datos_Perfil();
        
        setBackground(new Color(240, 240, 240));
    }
    
    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt){
        try {
            int edad = Integer.parseInt(txt_Edad.getText());
            String nombres = txt_Nombres.getText();
            String apellidos = txt_Apellidos.getText();
            String sexo = cmb_Genero.getSelectedItem().toString();
            String password = txt_Password.getText();
            String especialidad = txt_Especialidad.getText();
            int telefono = Integer.parseInt(txt_Telefono.getText());
            int codigo = doctor.getid();
            
            Persona_Controller persona_Controller = new Persona_Controller();
            persona_Controller.actualizar_Doctor(codigo, nombres, apellidos, password, edad, sexo, telefono, especialidad);
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del doctor correctamente");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Edad o Telefono no son numeros enteros");
        }
    }
    
    private void cargar_Datos_Perfil(){
        // Mostrar un cuadro de diálogo de entrada para que el usuario ingrese un código
        try{
            Persona_Controller persona_Controller = new Persona_Controller();
            int codigo = persona_Controller.get_id_Persona_Logueada();
            doctor = (Doctor)persona_Controller.buscar_Persona(codigo,"Doctor");
            if (doctor != null){
                txt_Nombres.setText(doctor.getNombre());
                txt_Apellidos.setText(doctor.getApellido());
                txt_Password.setText(doctor.getContraseña());
                txt_Especialidad.setText(doctor.getEspecialidad());
                txt_Telefono.setText(String.valueOf(doctor.getTelefono()));
                txt_Edad.setText(String.valueOf(doctor.getEdad()));
                cmb_Genero.setSelectedItem(doctor.getSexo());
            }else{
                JOptionPane.showMessageDialog(null, "Doctor no encontrado o no existe");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El codigo proporcionado debe ser numeros enteros");
        }
    }
}
