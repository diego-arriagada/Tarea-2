package org.tarea2;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;

abstract class Reunion {
    private Instant fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private TipoReunion tipo;
    private Empleado organizador;

    private ArrayList<Invitable> invitados = new ArrayList<>();
    private ArrayList<Asistencia> asistencias = new ArrayList<>();
    private ArrayList<String> notas = new ArrayList<>();
    private ArrayList<Asistencia> ausencias = new ArrayList<>();
    private ArrayList<Asistencia> atrasos = new ArrayList<>();

    public Reunion(Instant fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo, Empleado organizador) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
        this.organizador = organizador;
    }

    public void agregarInvitado(Invitable invitado) {
        invitados.add(invitado);
    }
    public void agregarNota(String nota) {
        notas.add(nota);
    }
    public ArrayList<Asistencia> obtenerAsistencia(){
        return asistencias;
    }
    public ArrayList<Asistencia> obtenerAusencias(){
        return ausencias;
    }
    public ArrayList<Asistencia> obtenerAtrasos(){
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
