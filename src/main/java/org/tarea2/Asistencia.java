package org.tarea2;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


class Asistencia {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
