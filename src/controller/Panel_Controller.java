
package controller;

import Panel.Panel_Login;
import Panel.Panel_Menu_Administrador;
import Panel.Panel_Registrarse;
import Panel.administrador.Panel_Control_Doctores;
import System.Main;
import View.Ventana_Base;

public class Panel_Controller {
    
    /*
        Esta clase me brinda a mi el control de todos los Paneles, para poder
        controlar las instancias y hacer el cambio en la ventana Base, para
        tener un mayor control sobre mi programa
    */
    
    Main main = new Main();
    
    public Panel_Login get_Panel_Login(){
        Panel_Login panel_Login = new Panel_Login();
        return panel_Login;
    }
    
    public Ventana_Base get_Ventana_Base(){
        return main.get_Ventana_Base();
    }
    
    public Panel_Registrarse get_Panel_Registrarse(){
        Panel_Registrarse panel_Registrarse = new Panel_Registrarse();
        return panel_Registrarse;
    }
    
    public Panel_Menu_Administrador get_Panel_Menu_Administrador(){
        Panel_Menu_Administrador panel_Men_Admin = new Panel_Menu_Administrador();
        return panel_Men_Admin;
    }
    
    public Panel_Control_Doctores get_Panel_Control_Doctores(){
        Panel_Control_Doctores panel_Control_Doc = new Panel_Control_Doctores();
        return panel_Control_Doc;
    }
        
}
