
package controller;

import Panel.Panel_Login;
import Panel.Panel_Menu_Administrador;
import Panel.Panel_Registrarse;
import Panel.administrador.Panel_Control_Doctores;
import Panel.administrador.Panel_Control_Pacientes;
import Panel.administrador.Panel_Control_Producto;
import Panel.administrador.Panel_Reportes;
import Panel.doctor.Panel_Citas_Doctor;
import Panel.doctor.Panel_Menu_Doctor;
import Panel.doctor.Panel_Perfil_Doctor;
import Panel.paciente.Panel_Menu_Paciente;
import Panel.paciente.Panel_Crear_Citas;
import Panel.paciente.Panel_Perfil;
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
    
    public Panel_Reportes get_Panel_Reportes(){
        Panel_Reportes panel_Rep = new Panel_Reportes();
        return panel_Rep;
    }
    
    public Panel_Control_Pacientes get_Panel_Control_Pacientes(){
        Panel_Control_Pacientes panel_Con_Pa = new Panel_Control_Pacientes();
        return panel_Con_Pa;
    }
    
    public Panel_Control_Producto get_Panel_Control_Producto(){
        Panel_Control_Producto panel = new Panel_Control_Producto();
        return panel;
    }
    
    public Panel_Menu_Paciente get_Panel_Menu_Paciente(){
        Panel_Menu_Paciente panel = new Panel_Menu_Paciente();
        return panel;
    }
    
    public Panel_Crear_Citas get_Panel_Crear_Citas(){
        Panel_Crear_Citas panel = new Panel_Crear_Citas();
        return panel;
    }
    
    public Panel_Perfil get_Panel_Perfil(){
        Panel_Perfil panel = new Panel_Perfil();
        return panel;
    }
    
    public Panel_Menu_Doctor get_Panel_Menu_Doctor(){
        Panel_Menu_Doctor panel = new Panel_Menu_Doctor();
        return panel;
    }
    
    public Panel_Perfil_Doctor get_Panel_Perfil_Doctor(){
        Panel_Perfil_Doctor panel = new Panel_Perfil_Doctor();
        return panel;
    }
    
    public Panel_Citas_Doctor get_Panel_Citas_Doc(){
        Panel_Citas_Doctor panel = new Panel_Citas_Doctor();
        return panel;
    }
}
