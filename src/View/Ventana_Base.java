
package View;

import Panel.Panel_Login;
import java.awt.BorderLayout;

public class Ventana_Base extends javax.swing.JFrame{
    
    //VARIABLES UTILIZADAS PARA INICIAR LA VENTANA BASE
    private javax.swing.JPanel panel_Base;
    //_____________________________________________________
    
    public Ventana_Base(){    
        initComponents();    
    }
    
    private void initComponents(){    
        //Generar panel base
        panel_Base = new Panel_Login();
        this.add(panel_Base);
        
        //Configuraciones de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CITAS DE HOSPITAL");
        this.setSize(800, 700);
        this.setResizable(false);  // No permite redimensionar la ventana
    }
    
    public void cambiarPaneles(javax.swing.JPanel miPanel){
        miPanel.setSize(800, 700); //Ancho y alto de los paneles colocados en la ventana
        miPanel.setLocation(0, 0); //Colocado en la posicion superior izquierda de la ventana
        panel_Base.removeAll();
        panel_Base.add(miPanel, BorderLayout.CENTER);
        panel_Base.revalidate();
        panel_Base.repaint();
    }
    
}
