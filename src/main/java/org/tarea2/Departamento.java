package org.tarea2;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    @Override
    public void invitar() {
        System.out.println("Invitando a todo el departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar();
        }
    }

    public String getNombre() { return nombre; }
    public List<Empleado> getEmpleados() { return empleados; }
}