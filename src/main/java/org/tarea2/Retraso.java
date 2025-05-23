package org.tarea2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Retraso extends Asistencia {
    private ArrayList<Instant> horasLlegada = new ArrayList<>();
    private ArrayList<Empleado> atrasados = new ArrayList<>();

    public Retraso(){}

    public void agregarEmpleadoTarde(Empleado empleado) {
        super.agregarEmpleado(empleado);
        atrasados.add(empleado);
        horasLlegada.add(Instant.now());
    }

    public ArrayList<Empleado> getEmpleadosTarde() {
        return atrasados;
    }

    public ArrayList<Instant> getHorasLlegada() {
        return horasLlegada;
    }
    public Instant getAtraso(Empleado empleado){
        int indice = atrasados.indexOf(empleado);
        return horasLlegada.get(indice);
    }
}
