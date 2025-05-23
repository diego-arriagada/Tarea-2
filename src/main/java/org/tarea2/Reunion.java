package org.tarea2;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter; // usado para escribir el texto en buen formato
import java.time.ZoneId;                   // Tambien

abstract class Reunion {
    private static int contadorReuniones = 0;
    private final int numeroReunion;
    private Instant fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private TipoReunion tipo;
    private Empleado organizador;

    private ArrayList<Invitacion> invitados = new ArrayList<>();
    private ArrayList<String> notas = new ArrayList<>();
    private ArrayList<Empleado> asistencias = new ArrayList<>();
    private ArrayList<Empleado> ausencias = new ArrayList<>();
    private ArrayList<Empleado> atrasos = new ArrayList<>();
    private ArrayList<Instant> horasLlegada = new ArrayList<>();

    public Reunion(Instant fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo, Empleado organizador) {
        contadorReuniones++;
        this.numeroReunion = contadorReuniones;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
        this.organizador = organizador;
    }

    public void agregarNota(String nota) {
        notas.add(nota);
    }
    public ArrayList<Empleado> obtenerAsistencia(){
        return asistencias;
    }
    public ArrayList<Empleado> obtenerAusencias(){
        return ausencias;
    }
    public ArrayList<Empleado> obtenerAtrasos(){
        return atrasos;
    }
    public int obtenerTotalAsistencia(){
        return asistencias.size();
    }
    public float obtenerPorcentajeAsistencia(){
        return (float) asistencias.size() /invitados.size() * 100;
    }
    public float calcularTiempoReal(){
        Duration tiempoReunion = Duration.between(horaInicio, horaFin);
        return tiempoReunion.toSeconds();
        //return (float) tiempoReunion.toSeconds()/3600; Opcion para retornar en formato de horas la duracion total para que tenga sentido que retorne un float
    }
    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFin = Instant.now();
        try {
            FileWriter writer = new FileWriter("reunion" + numeroReunion + ".txt");
            DateTimeFormatter formatter = DateTimeFormatter
                    .ofPattern("dd/MM/yyyy HH:mm:ss")
                    .withZone(ZoneId.systemDefault());
            writer.write("Fecha y hora de inicio: "+ formatter.format(horaPrevista) + "\n");
            writer.write("Hora de inicio de la reunion: " + formatter.format(horaInicio)+"\n");
            writer.write("Hora de fin de la reunion: " + formatter.format(horaFin) + "\n");
            Duration duracionReunion = Duration.between(horaPrevista,horaFin);
            writer.write("Duracion de la reunion: " + duracionReunion.toMinutes()+"\n");
            writer.write("Tipo de reunion: " + tipo+"\n");
            if(this instanceof ReunionPresencial){
                writer.write("La reunion fue presencial, la sala fue: " + ((ReunionPresencial) this).getSala());
            } else if(this instanceof ReunionVirtual){
                writer.write("La reunion fue virtual, el enlace fue: " + ((ReunionVirtual) this).getEnlace());
            }
            writer.write("\n");
            writer.write("Lista de participantes y informacion sobre retrasos: \n");
            for(Empleado asistencia : asistencias){
                writer.write(asistencia.getEmpleado().getNombre()+ " " + asistencia.getEmpleado().getApellidos());
                if(asistencia.esRetraso()){
                    Duration retrasoEmpleado = Duration.between(horaInicio,asistencia.getHora());
                    writer.write("// Retraso: " + retrasoEmpleado.toMinutes() + "\n");
                }
            }
            writer.write("Notas de la reunion en orden cronologico:\n");
            for(String nota : notas){
                writer.write(nota + "\n");
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
    public Instant getFecha() {
        return fecha;
    }
    public Instant getHoraPrevista() {
        return horaPrevista;
    }
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    public Instant getHoraInicio() {
        return horaInicio;
    }
    public Instant getHoraFin() {
        return horaFin;
    }
    
}
