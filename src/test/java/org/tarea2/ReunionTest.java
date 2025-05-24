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
    private Departamento departamento3;
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
        departamento3 = new Departamento("3");
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
        reunion.agregarInvitado(empleadoDuplicado);
        reunion.agregarInvitado(empleadoDuplicado);

        reunion.finalizar();


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



        long conteoMismoEmpleado = reunion.getInvitados().stream().filter(empleado -> empleado.equals(empleadoDuplicado)).count();
        assertEquals(1,conteoMismoEmpleado);

    }

    @Test
    void testMarcarAsistencia() throws InterruptedException {

        Empleado empleadoAntes = new Empleado("11","Galaz","Victor","victorgal@empresa.cl",departamento1);
        Empleado empleadoJusto = new Empleado("21","Perez","Juan","juanper@empresa.cl",departamento2);
        Empleado empleadoDespues = new Empleado("01", "Arriagada", "Diego", "diegoarr@empresa.cl", departamento1);
        Empleado empleadoNoInvitado = new Empleado("22","Martinez","Nicolas","nicolasmar@empresa.cl",departamento3);
        Empleado empleadoDuplicado = new Empleado ("10","Soto","Martin","martinsot@empresa.cl",departamento1);
        Externo externo1 = new Externo("100","Catril","Matias");
        Empleado empleadoNull = null;
        Empleado empleadoAusente = new Empleado("atrasado", "atrasado", "atrasado", "atraso", departamento1);

        departamento1.invitar(reunion);
        departamento2.invitar(reunion);
        externo1.invitar(reunion);

        reunion.marcarAsistencia(empleadoNull);
        reunion.marcarAsistencia(empleadoAntes);
        Thread.sleep(4900);
        reunion.marcarAsistencia(empleadoJusto);
        Thread.sleep(1000);
        reunion.marcarAsistencia(empleadoDespues);
        reunion.marcarAsistencia(empleadoDuplicado);
        reunion.marcarAsistencia(empleadoDuplicado);
        reunion.marcarAsistencia(externo1);
        reunion.marcarAsistencia(empleadoNoInvitado);

        System.out.println(reunion.obtenerAusencias());
        assertTrue(reunion.obtenerAusencias().contains(empleadoAusente)); //Comprueba que las ausencias se modifiquen correctamente al inicio
        assertTrue(reunion.obtenerAusencias().contains(empleadoAntes));
        assertTrue(reunion.obtenerAusencias().contains(empleadoJusto));
        assertTrue(reunion.obtenerAusencias().contains(empleadoDespues));
        assertTrue(reunion.obtenerAusencias().contains(empleadoDuplicado));
        assertTrue(reunion.obtenerAusencias().contains(externo1));


        reunion.finalizar();
        reunion.marcarAsistencia(empleadoAusente);


        assertTrue(reunion.obtenerAsistencia().contains(empleadoAntes)); //Test para comprobar que la lista de asistencia se modifica correctamente
        assertTrue(reunion.obtenerAsistencia().contains(empleadoJusto));
        assertTrue(reunion.obtenerAsistencia().contains(empleadoDespues));
        assertTrue(reunion.obtenerAsistencia().contains(empleadoDuplicado));
        assertTrue(reunion.obtenerAsistencia().contains(externo1));
        assertFalse(reunion.obtenerAsistencia().contains(empleadoNoInvitado));
        assertFalse(reunion.obtenerAsistencia().contains(empleadoNull));
        assertFalse(reunion.obtenerAsistencia().contains(empleadoAusente));

        long conteoMismoEmpleado = reunion.obtenerAsistencia().stream().filter(empleado -> empleado.equals(empleadoDuplicado)).count();
        assertEquals(1,conteoMismoEmpleado); //Comprueba que no se puedan añadir duplicados


        assertTrue(reunion.obtenerAusencias().contains(empleadoAusente)); //Comprueba que las ausencias se modifiquen correctamente
        assertFalse(reunion.obtenerAusencias().contains(empleadoAntes));
        assertFalse(reunion.obtenerAusencias().contains(empleadoJusto));
        assertFalse(reunion.obtenerAusencias().contains(empleadoDespues));
        assertFalse(reunion.obtenerAusencias().contains(empleadoDuplicado));
        assertFalse(reunion.obtenerAusencias().contains(externo1));

        assertTrue(reunion.obtenerAtrasos().contains(empleadoDespues));
        assertFalse(reunion.obtenerAtrasos().contains(empleadoAntes));
        assertFalse(reunion.obtenerAtrasos().contains(empleadoJusto));
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