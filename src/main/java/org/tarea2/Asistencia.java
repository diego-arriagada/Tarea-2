package org.tarea2;
import java.util.ArrayList;

/**
 * La clase Asistencia cumple la función de almacenar los empleados que asistieron a una reunión.
 *
 * Maneja la lista de asistencia como arreglos de objetos Empleado y permite agregar empleados a la lista mediante un método.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Asistencia {
    private ArrayList<Empleado> asistentes = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null){
            return;
        }
        asistentes.add(empleado);
    }

    public ArrayList<Empleado> getAsistencias() {
        return asistentes;
    }

    @Override
    public String toString() {
        return "asistentes = " + getAsistencias();
    }
}
