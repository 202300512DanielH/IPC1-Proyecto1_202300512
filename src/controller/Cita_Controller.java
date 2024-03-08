
package controller;

import Models.Cita;
import java.util.ArrayList;

public class Cita_Controller {
    
    static int contador = 1;
    
    public Cita generar_Cita(int id_Doctor, int id_Paciente, String horario, String fecha, String motivo){
        Cita cita_Nueva = new Cita(contador, id_Doctor, id_Paciente, horario, fecha, motivo, "Pendiente");
        contador++;
        return cita_Nueva;
    }
    
    public ArrayList<Cita> actualizar_Lista_Citas(int id_Cita, ArrayList<Cita> lista_Citas, String estado_Cita, String rol){
        int contador = 0;
        for( Cita cita: lista_Citas ){
            if( cita.getId() == id_Cita ){
                if(rol.equals("Doctor")){
                    lista_Citas.remove(contador);
                    return lista_Citas;
                }else{
                    cita.setEstado_Cita(estado_Cita);
                    lista_Citas.set(contador, cita);
                    return lista_Citas;
                }
            }
            contador++;
        }
        return null;
    }
    
}
