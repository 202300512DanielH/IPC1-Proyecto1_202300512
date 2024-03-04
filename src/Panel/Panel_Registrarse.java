
package Panel;

public class Panel_Registrarse extends javax.swing.JPanel{
    
    private javax.swing.JLabel titulo;
    
    public Panel_Registrarse(){
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        
        titulo = new javax.swing.JLabel();
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Registrarse");
        titulo.setBounds(320, 100, 170, 30);
        this.add(titulo);
        
        setBackground(new java.awt.Color(210,242,238));
    }
    
}
