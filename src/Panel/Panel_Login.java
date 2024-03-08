
package Panel;

import controller.Panel_Controller;
import controller.Persona_Controller;

public class Panel_Login extends javax.swing.JPanel{
    
    javax.swing.JPanel panelFind = null;    
    //Declaracion de variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_Registrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JPasswordField txt_Password;
    //__________________________
    
    public Panel_Login(){
        initComponents();
    }
    
    private void initComponents(){
        setLayout(null);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        btn_Login = new javax.swing.JButton();
        txt_Codigo = new javax.swing.JTextField();
        btn_Registrate = new javax.swing.JButton();
        txt_Codigo = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INICIAR SESIÓN");
        jLabel1.setBounds(320, 100, 170, 30);
        this.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Código:");
        jLabel2.setBounds(200, 200, 80, 25);
        this.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password:");
        jLabel3.setBounds(200, 250, 80, 25);
        this.add(jLabel3);
        
        txt_Codigo.setBounds(300, 200, 200, 25);
        txt_Codigo.setText("202300512");
        add(txt_Codigo);
        
        txt_Password.setBounds(300, 250, 200, 25);
        txt_Password.setText("proyecto1IPC1");
        add(txt_Password);

        btn_Login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(0, 0, 0));
        btn_Login.setText("Login");
        btn_Login.setBounds(250, 320, 100, 30);
        /*
            En este apartado siguiente yo le asigno a mi boton la funcionalidad de un
            action listener, el cual quedara pendiente a cualquier accion que se le de
            al boton, como es un click, se crea una nueva instancia del action listener y
            a su vez el encargado de realizar las acciones sera mi funcion
            btn_LoginActionPerformed.
        */
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        this.add(btn_Login);
        
        btn_Registrate = new javax.swing.JButton("Registrate");
        btn_Registrate.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Registrate.setForeground(new java.awt.Color(0, 0, 0));
        btn_Registrate.setBounds(370, 320, 120, 30);
        btn_Registrate.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btn_RegistrateActionPerformed(evt);
            }
        });
        add(btn_Registrate);
        
        setBackground(new java.awt.Color(201,252,238));
    }
    
    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt){
        //Aqui la funcionalidad de mi boton ingresar
        int codigo = Integer.parseInt(txt_Codigo.getText());
        String password = txt_Password.getText();
        
        Persona_Controller p_Controller = new Persona_Controller();
        panelFind = p_Controller.Login(codigo, password);
        Panel_Controller panel_Controller = new Panel_Controller();
        
        if(panelFind != null){
            panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
        }
    }
    
    private void btn_RegistrateActionPerformed(java.awt.event.ActionEvent evt){
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Registrarse();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
}
