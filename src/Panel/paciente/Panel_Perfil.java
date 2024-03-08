
package Panel.paciente;

import Models.Paciente;
import controller.Persona_Controller;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Panel_Perfil extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;
    private Paciente paciente;
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
    private javax.swing.JButton btn_Actualizar;
    
    public Panel_Perfil(){
        initComponents();
    }
    
    public void initComponents(){
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
        btn_Actualizar = new javax.swing.JButton();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Perfil Del Paciente");
        titulo.setBounds(290, 50, 300, 30);
        this.add(titulo);
        
        final int lbl_txt_Height = 25;
        
        lbl_Nombres.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Nombres.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Nombres.setText("Nombres:");
        lbl_Nombres.setBounds(100, 150, 80, 25);
        this.add(lbl_Nombres);
        
        lbl_Apellidos.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Apellidos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Apellidos.setText("Apellidos:");
        lbl_Apellidos.setBounds(100, 200, 80, 25);
        this.add(lbl_Apellidos);
        
        lbl_Password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Password.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Password.setText("Contraseña:");
        lbl_Password.setBounds(100, 250, 80, 25);
        this.add(lbl_Password);
        
        lbl_Genero.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Genero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Genero.setText("Género:");
        lbl_Genero.setBounds(100, 300, 80, 25);
        this.add(lbl_Genero);
        
        lbl_Edad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Edad.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Edad.setText("Edad:");
        lbl_Edad.setBounds(100, 350, 80, 25);
        this.add(lbl_Edad);
        
        txt_Nombres.setBounds(200, 150, 200, 25);
        this.add(txt_Nombres);
        
        txt_Apellidos.setBounds(200, 200, 200, 25);
        this.add(txt_Apellidos);
        
        txt_Password.setBounds(200, 250, 200, 25);
        this.add(txt_Password);
        
        cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmb_Genero.setBounds(200, 300, 200, 25);
        this.add(cmb_Genero);
        
        txt_Edad.setBounds(200, 350, 200, 25);
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
        
        setBackground(new Color(240, 240, 240));
    }
    
    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt){
        // Mostrar un cuadro de diálogo de entrada para que el usuario ingrese un código
        try {
            int edad = Integer.parseInt(txt_Edad.getText());
            String nombres = txt_Nombres.getText();
            String apellidos = txt_Apellidos.getText();
            String sexo = cmb_Genero.getSelectedItem().toString();
            String password = txt_Password.getText();            
            Persona_Controller persona_Controller = new Persona_Controller();
            persona_Controller.actualizar_Paciente(paciente.getid(), nombres, apellidos, password, edad, sexo);
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del paciente correctamente");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Edad debe ser un numero entero");
        }
    }
    
    private void cargar_Datos_Perfil(){
        Persona_Controller persona_Controller = new Persona_Controller();
        int codigo = persona_Controller.get_id_Persona_Logueada();
        paciente = (Paciente)persona_Controller.buscar_Persona(codigo,"Paciente");
        if (paciente != null){
            txt_Nombres.setText(paciente.getNombre());
            txt_Apellidos.setText(paciente.getApellido());
            txt_Password.setText(paciente.getContraseña());
            txt_Edad.setText(String.valueOf(paciente.getEdad()));
            cmb_Genero.setSelectedItem(paciente.getSexo());
        }else{
            JOptionPane.showMessageDialog(null, "paciente no encontrado o no existe");
        }
    }
}
