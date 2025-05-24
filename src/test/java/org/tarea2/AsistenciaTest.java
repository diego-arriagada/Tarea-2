package org.tarea2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest extends Asistencia {
    private Departamento departamento1;
    private Empleado organizador;
    private Instant ahora;
    private Asistencia asistencias;
    private Empleado empleadoNulo;

    @BeforeEach
    void setUp() {
        departamento1 = new Departamento("1");
        organizador = new Empleado("123","Diego","Arriagada","diegoarriagada@gmail.com",departamento1);
        asistencias = new Asistencia();
        empleadoNulo = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAgregarEmpleado() {
        ahora = Instant.now();
        asistencias.agregarEmpleado(organizador);
        assertTrue(asistencias.getAsistencias().contains(organizador));
        asistencias.agregarEmpleado(empleadoNulo);
        assertFalse(asistencias.getAsistencias().contains(empleadoNulo));

    }
}