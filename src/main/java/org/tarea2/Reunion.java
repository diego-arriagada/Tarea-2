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

    // faltan todos los metodos y getters
}
