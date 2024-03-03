
package Models;

public class Cita {
    private int id;
    private int id_Doctor;
    private int id_Paciente;
    private String horario;
    private String fecha;
    private String motivo;
    private String estado_Cita;
    
    // Constructor
    public Cita(int id, int id_Doctor, int id_Paciente, String horario, String fecha, String motivo, String estado_Cita) {
        this.id = id;
        this.id_Doctor = id_Doctor;
        this.id_Paciente = id_Paciente;
        this.horario = horario;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado_Cita = estado_Cita;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Doctor() {
        return id_Doctor;
    }

    public void setId_Doctor(int id_Doctor) {
        this.id_Doctor = id_Doctor;
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado_Cita() {
        return estado_Cita;
    }

    public void setEstado_Cita(String estado_Cita) {
        this.estado_Cita = estado_Cita;
    }
}

