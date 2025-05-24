package org.tarea2;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Departamento representa un departamento compuesto por empleados.
 *
 * Permite agrupar empleados en diferentes grupos relevantes a la hora de crear reuniones.
 * Además, implementa la interfaz Invitable para invitar a todos los empleados del departamento a una reunión.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que permite agregar un empleado al departamento.
     *
     * @param empleado El empleado a agregar al departamento.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    /**
     * Invita a todos los empleados del departamento a una reunión.
     *
     * @param reunion La reunión a la que se invitarán los empleados del departamento.
     */
    @Override
    public void invitar(Reunion reunion) {
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion);
        }
    }

    public String getNombre() { return nombre; }
    public List<Empleado> getEmpleados() { return empleados; }

    @Override
    public String toString() {
        return "departamento = " + getNombre() + "\nempleados = " + getEmpleados();
    }
}