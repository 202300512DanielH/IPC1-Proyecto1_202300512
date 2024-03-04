
package controller;

import java.util.ArrayList;
import Models.Persona;
import javax.swing.JOptionPane;

public class Persona_Controller {
    
    static ArrayList<Persona> lista_Usuarios = new ArrayList<Persona>();
    static Persona admin = new Persona(202300512, "admin", "", "proyecto1IPC1", "", 0, "ADMIN");
    
    public javax.swing.JPanel Login(int codigo, String password){
        
        if (admin.getid() == codigo && admin.getContraseña().equals(password)){
            JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");
            return null;
        }
        
        for (int i = 0; i < lista_Usuarios.size(); i++){
            Persona persona = lista_Usuarios.get(i);
            if (persona.getid() == codigo && persona.getContraseña().equals(password)){
                JOptionPane.showMessageDialog(null, "Se ha iniciado Sesion");
                return null;
            }
        }
        JOptionPane.showMessageDialog(null,"Contraseña o codigo incorrecto");
        return null;
    }
    
    public ArrayList<Persona> get_Lista_Usuarios(){
        return lista_Usuarios;
    }
}
