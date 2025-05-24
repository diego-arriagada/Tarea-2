package org.tarea2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RetrasoTest es una clase de prueba para la clase Retraso.
 *
 * Prubea el caso del empleado nulo y se asegura de que el codigo guarde correctamente la hora de retraso.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

class RetrasoTest extends Asistencia {
    private Departamento departamento1;
    private Empleado organizador;
    private Instant ahora;
    private Retraso atrasados;
    private Empleado empleadoNulo;

    @BeforeEach
    void setUp() {
        departamento1 = new Departamento("1");
        organizador = new Empleado("123","Diego","Arriagada","diegoarriagada@gmail.com",departamento1);
        atrasados = new Retraso();
        empleadoNulo = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void agregarEmpleadoTarde() {
        ahora = Instant.now();
        atrasados.agregarEmpleadoTarde(organizador);
        assertTrue(atrasados.getEmpleadosTarde().contains(organizador));
        assertTrue(atrasados.getHorasLlegada().contains(ahora));
        atrasados.agregarEmpleadoTarde(empleadoNulo);
        assertFalse(atrasados.getEmpleadosTarde().contains(empleadoNulo));
    }
}