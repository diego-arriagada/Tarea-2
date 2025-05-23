package org.tarea2;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


class Asistencia {
    private ArrayList<Empleado> asistentes = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        asistentes.add(empleado);
    }

    public ArrayList<Empleado> getAsistencias() {
        return asistentes;
    }
}
