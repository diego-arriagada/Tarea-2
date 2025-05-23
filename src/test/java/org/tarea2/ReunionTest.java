package org.tarea2;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ReunionTest {
    private Departamento departamento1;
    private Departamento departamento2;
    private Empleado organizador;
    private Reunion reunion;
    private Instant ahora;
    private Instant horaPrevista;

    @BeforeEach
    void setUp() {
        departamento1 = new Departamento("1");
        organizador = new Empleado("123","Diego","Arriagada","diegoarriagada@gmail.com",departamento1);

        departamento2 = new Departamento("2");
        ahora = Instant.now();
        horaPrevista = ahora.plus(5,ChronoUnit.SECONDS);
        reunion = new ReunionPresencial(ahora, horaPrevista, Duration.ofHours(1),TipoReunion.TECNICA,organizador,"Sala 1");
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testAgregarInvitado() throws Exception  {
        Empleado empleadoNormal1 = new Empleado("11","Galaz","Victor","victorgal@empresa.cl",departamento1);
        Empleado empleadoNormal2 = new Empleado("21","Perez","Juan","juanper@empresa.cl",departamento2);
        Empleado empleadoNoInvitado = new Empleado("22","Martinez","Nicolas","nicolasmar@empresa.cl",departamento2);
        Empleado empleadoDuplicado = new Empleado ("10","Soto","Martin","martinsot@empresa.cl",departamento1);
        Externo externo1 = new Externo("100","Catril","Matias");
        Empleado empleadoNull = null;


        reunion.agregarInvitado(empleadoNormal1);
        reunion.agregarInvitado(empleadoNormal2);
        reunion.agregarInvitado(externo1);



        assertTrue(reunion.getInvitados().contains(empleadoNormal1));
        assertTrue(reunion.getInvitados().contains(empleadoNormal2));
        assertFalse(reunion.getInvitados().contains(empleadoNoInvitado));
        assertTrue(reunion.getInvitados().contains(externo1));
        assertFalse(reunion.getInvitados().contains(empleadoNull));

        assertTrue(reunion.obtenerAusencias().contains(empleadoNormal1));
        assertTrue(reunion.obtenerAusencias().contains(empleadoNormal2));
        assertFalse(reunion.obtenerAusencias().contains(empleadoNoInvitado));
        assertTrue(reunion.obtenerAusencias().contains(externo1));
        assertFalse(reunion.obtenerAusencias().contains(empleadoNull));

        reunion.agregarInvitado(empleadoDuplicado);
        reunion.agregarInvitado(empleadoDuplicado);

        long conteoMismoEmpleado = reunion.getInvitados().stream().filter(empleado -> empleado.equals(empleadoDuplicado)).count();
        assertEquals(1,conteoMismoEmpleado);

    }

    @Test
    void testMarcarAsistencia() throws InterruptedException {

        Empleado empleadoAntes = new Empleado("11","Galaz","Victor","victorgal@empresa.cl",departamento1);
        Empleado empleadoJusto = new Empleado("21","Perez","Juan","juanper@empresa.cl",departamento2);
        Empleado empleadoDespues = new Empleado("01", "Arriagada", "Diego", "diegoarr@empresa.cl", departamento1);
        Empleado empleadoNoInvitado = new Empleado("22","Martinez","Nicolas","nicolasmar@empresa.cl",departamento2);
        Empleado empleadoDuplicado = new Empleado ("10","Soto","Martin","martinsot@empresa.cl",departamento1);
        Externo externo1 = new Externo("100","Catril","Matias");
        Empleado empleadoNull = null;

        reunion.marcarAsistencia(empleadoNull);
        reunion.marcarAsistencia(empleadoAntes);
        Thread.sleep(5000);
        reunion.marcarAsistencia(empleadoJusto);
        Thread.sleep(1000);
        reunion.marcarAsistencia(empleadoDespues);
        reunion.marcarAsistencia(empleadoDuplicado);
        reunion.marcarAsistencia(empleadoDuplicado);
        reunion.marcarAsistencia(externo1);
        reunion.marcarAsistencia(empleadoNoInvitado);

        assertTrue

    }

    @Test
    void testAgregarNota() {
    }

    @Test
    void testCalcularTiempoReal() {
    }

    @Test
    void testIniciar() {
    }

    @Test
    void testFinalizar() {
    }
}