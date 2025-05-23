package org.tarea2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Retraso extends Asistencia {
    private List<Instant> horasLlegada = new ArrayList<>();
    private List<Empleado> atrasados = new ArrayList<>();

    public void agregarEmpleadoTarde(Empleado empleado, Instant hora) {
        super.agregarEmpleado(empleado);
        atrasados.add(empleado);
        horasLlegada.add(hora);
    }

    public List<Empleado> getEmpleadosTarde() {
        return super.getEmpleados();
    }

    public List<Instant> getHorasLlegada() {
        return horasLlegada;
    }
}
