
package Panel;

import controller.Panel_Controller;
import controller.Persona_Controller;
import javax.swing.JOptionPane;

public class Panel_Registrarse extends javax.swing.JPanel{
    
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
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Registrarse;
    
    public Panel_Registrarse(){
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
        btn_Regresar = new javax.swing.JButton();
        btn_Registrarse = new javax.swing.JButton();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Registrate Aquí");
        titulo.setBounds(320, 50, 170, 30);
        this.add(titulo);
        
        lbl_Nombres.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Nombres.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Nombres.setText("Nombres:");
        lbl_Nombres.setBounds(250, 150, 80, 25);
        this.add(lbl_Nombres);
        
        lbl_Apellidos.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Apellidos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Apellidos.setText("Apellidos:");
        lbl_Apellidos.setBounds(250, 200, 80, 25);
        this.add(lbl_Apellidos);
        
        lbl_Password.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Password.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Password.setText("Contraseña:");
        lbl_Password.setBounds(250, 250, 80, 25);
        this.add(lbl_Password);
        
        lbl_Genero.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Genero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Genero.setText("Género:");
        lbl_Genero.setBounds(250, 300, 80, 25);
        this.add(lbl_Genero);
        
        lbl_Edad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Edad.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Edad.setText("Edad:");
        lbl_Edad.setBounds(250, 350, 80, 25);
        this.add(lbl_Edad);
        
        txt_Nombres.setBounds(350, 150, 200, 25);
        this.add(txt_Nombres);
        
        txt_Apellidos.setBounds(350, 200, 200, 25);
        this.add(txt_Apellidos);
        
        txt_Password.setBounds(350, 250, 200, 25);
        this.add(txt_Password);
        
        cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmb_Genero.setBounds(350, 300, 200, 25);
        this.add(cmb_Genero);
        
        txt_Edad.setBounds(350, 350, 200, 25);
        this.add(txt_Edad);
        
        btn_Regresar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Regresar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Regresar.setText("Regresar");
        btn_Regresar.setBounds(250, 400, 150, 30);
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });
        this.add(btn_Regresar);
        
        btn_Registrarse.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Registrarse.setForeground(new java.awt.Color(0, 0, 0));
        btn_Registrarse.setText("Crear Cuenta");
        btn_Registrarse.setBounds(450, 400, 150, 30);
        btn_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarseActionPerformed(evt);
            }
        });
        this.add(btn_Registrarse);
        
        setBackground(new java.awt.Color(210,242,238));
    }
    
    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Login();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
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
            panelFind = panel_Controller.get_Panel_Login();
            panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La edad debe ser numeros enteros");            
        }
    }
}
