package org.tarea2;

import java.time.Instant;
import java.util.ArrayList;

/**
 * La clase Retraso hereda de la clase Asistencia y se encarga de almacenar los empleados que llegaron tarde a una reunión.
 *
 * Maneja la lista de empleados que llegaron tarde como arreglos de objetos Empleado y permite agregar empleados a la lista mediante un método.
 * Además, almacena la hora de llegada de cada empleado atrasado.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

class Retraso extends Asistencia {
    private ArrayList<Instant> horasLlegada = new ArrayList<>();
    private ArrayList<Empleado> atrasados = new ArrayList<>();

    public Retraso(){}

    /**
     * Método que agrega un empleado a la lista de asistencia, a la lista de atrasados, y registra su hora de llegada.
     *
     * @param empleado El empleado que llegó tarde.
     */
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
