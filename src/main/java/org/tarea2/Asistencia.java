package org.tarea2;
import java.time.Instant;

class Asistencia {
    private Empleado empleado;
    private Instant hora;
    private boolean retraso;

    public Asistencia(Empleado empleado, Instant hora, boolean retraso) {
        this.empleado = empleado;
        this.hora = hora;
        this.retraso = retraso;
    }

    // Getters
    public Empleado getEmpleado() { return empleado; }
    public Instant getHora() { return hora; }
    public boolean esRetraso() { return retraso; }
}
