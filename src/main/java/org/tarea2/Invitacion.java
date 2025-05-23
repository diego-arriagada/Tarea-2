package org.tarea2;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant horaInicio;
    public Invitacion(Instant hora){
        this.horaInicio = hora;
        ArrayList<String> idEmpleado = new ArrayList<>();
        ArrayList<Instant> horaLlegada = new ArrayList<>();
    }

    public void invitar(Empleado empleado){
        System.out.println("Invitando al empleado: " + empleado.getNombre() + " " + empleado.getApellidos() + " (" + empleado.getCorreo() + ")");
    }

}
