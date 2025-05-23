package org.tarea2;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter; // usado para escribir el texto en buen formato
import java.time.ZoneId;                   // Tambien

/**
 * La clase Reunion representa una reunión programada por un organizador y con una lista de invitados.
 *
 * Permite agregar invitados, marcar asistencia, agregar notas, iniciar la reunion, finalizar la reunion y calcular el tiempo real de la reunión.
 * Además, permite generar un informe de la reunión en un archivo de texto.
 * Este informe incluye todas las propiedades relevantes de la reunion.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public abstract class Reunion {
    private static int contadorReuniones = 0;
    private final int numeroReunion;
    private Instant fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    public Boolean reunionIniciada = false;
    public Boolean reunionFinalizada = false;

    private TipoReunion tipo;
    private Empleado organizador;
    private Asistencia asistencias = new Asistencia();
    private Retraso atrasos = new Retraso();

    private ArrayList<Empleado> invitados = new ArrayList<>();
    private ArrayList<Nota> notas = new ArrayList<>();
    private ArrayList<Empleado> ausencias = new ArrayList<>();
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

    /**
     * Método que agrega un invitado a la reunión.
     *
     * Funciona como un filtro para evitar que se agreguen empleados duplicados a la lista de invitados.
     *
     * @param empleado El empleado que se va a agregar como invitado.
     */
    public void agregarInvitado(Empleado empleado){
        if((this.getInvitados().stream().filter(comp -> comp.equals(empleado)).count()) == 0) {
            invitados.add(empleado);
        }
        if((this.obtenerAusencias().stream().filter(comp -> comp.equals(empleado)).count()) == 0){
        ausencias.add(empleado);
            }
        }

    public ArrayList<Empleado> getInvitados(){
        return invitados;
    }

    /**
     * Método para marcar la asistencia de un empleado a la reunión.
     *
     *
     *
     *
     */
    public void marcarAsistencia(Empleado empleado){
        Duration auxiliarAtraso = Duration.between(Instant.now(),horaPrevista);
        if(invitados.contains(empleado)) {
            if ((int) auxiliarAtraso.toSeconds() >= 0) {
                asistencias.agregarEmpleado(empleado);
            } else {
                asistencias.agregarEmpleado(empleado);
                atrasos.agregarEmpleadoTarde(empleado);
            }
        }
    }

    public void agregarNota(String texto) {
        Nota nota = new Nota(texto);
        notas.add(nota);
    }
    public ArrayList<Empleado> obtenerAsistencia(){
        return asistencias.getAsistencias();
    }
    public ArrayList<Empleado> obtenerAusencias(){
        return ausencias;
    }
    public ArrayList<Empleado> obtenerAtrasos(){
        return atrasos.getEmpleadosTarde();
    }
    public int obtenerTotalAsistencia(){
        return asistencias.getAsistencias().size();
    }
    public float obtenerPorcentajeAsistencia(){
        return (float) asistencias.getAsistencias().size() /invitados.size() * 100;
    }

    /**
     * Método que calcula el tiempo real de la reunión en minutos.
     *
     * @return El tiempo real de la reunión en minutos.
     */
    public float calcularTiempoReal(){
        Duration tiempoReunion = Duration.between(horaInicio, horaFin);
        return (float) tiempoReunion.toSeconds()/60;
    }

    /**
     * Método que inicia la reunión.
     *
     * @return El tiempo restante para la reunión en minutos.
     */
    public void iniciar(){
        if(!reunionIniciada && !reunionFinalizada){
            this.horaInicio = Instant.now();
            reunionIniciada = true;
        }
    }

    /**
     * Método que finaliza la reunión.
     *
     * Genera un informe de la reunión en un archivo de texto.
     */
    public void finalizar(){
        if(reunionIniciada && !reunionFinalizada){
            this.horaFin = Instant.now();
            ausencias.removeAll(asistencias.getAsistencias());             //Removemos de los ausentes a todos los que llegaron

            try {
                FileWriter writer = new FileWriter("reunion" + numeroReunion + ".txt");
                DateTimeFormatter formatter = DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm:ss")
                        .withZone(ZoneId.systemDefault());
                writer.write("Fecha y hora de inicio prevista: "+ formatter.format(horaPrevista) + "\n");
                writer.write("Hora de inicio de la reunion: " + formatter.format(horaInicio)+"\n");
                writer.write("Hora de fin de la reunion: " + formatter.format(horaFin) + "\n");
                writer.write("Duracion de la reunion: " + this.calcularTiempoReal() + "\n");
                writer.write("Tipo de reunion: " + tipo+"\n");
                if(this instanceof ReunionPresencial){
                    writer.write("La reunion fue presencial, la sala fue: " + ((ReunionPresencial) this).getSala());
                } else if(this instanceof ReunionVirtual){
                    writer.write("La reunion fue virtual, el enlace fue: " + ((ReunionVirtual) this).getEnlace());
                }
                writer.write("\n");
                writer.write("Lista de participantes y informacion sobre retrasos: \n");
                for(Empleado empleado : asistencias.getAsistencias()){
                    writer.write(empleado.getNombre()+ " " + empleado.getApellidos());
                    DateTimeFormatter formatterDuration = DateTimeFormatter
                            .ofPattern("mm:ss")
                            .withZone(ZoneId.systemDefault());
                    if(atrasos.getEmpleadosTarde().contains(empleado)){
                        Duration retrasoEmpleado = Duration.between(horaInicio, atrasos.getAtraso(empleado));
                        String retrasoFormateado = String.format("%d:%02d",
                                retrasoEmpleado.toMinutes(),
                                retrasoEmpleado.toSecondsPart());

                        writer.write(" // Retraso: " + retrasoFormateado + "\n");
                    } else {
                        writer.write("\n");
                    }
                }
                writer.write("Notas de la reunion en orden cronologico:\n");
                for(Nota nota : notas){
                    writer.write(nota.getTexto() + "\n");
                }
                writer.close();
            } catch (IOException e){
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
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
