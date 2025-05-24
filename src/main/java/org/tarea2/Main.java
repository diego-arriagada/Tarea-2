package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Instant ahora = Instant.now();
        Instant inicio = ahora.plus(1, ChronoUnit.SECONDS);
        Instant despues = ahora.plus(10, ChronoUnit.SECONDS);
        Departamento depa = new Departamento("Departamento1");
        Empleado e1 = new Empleado("123", "hola", "Diego", "asd", depa);
        Empleado e2 = new Empleado("1234", "hola", "Matias", "mcatril", depa);
        Empleado e3 = new Empleado("123", "hola", "Victor", "qwe", depa);
        Reunion reun = new ReunionPresencial(inicio, inicio, Duration.between(Instant.now(), ahora), TipoReunion.OTRO, e3, "Sala 4");
        Invitacion invi = new Invitacion(reun, depa);
        Invitacion invit = new Invitacion(reun,e1);
        reun.marcarAsistencia(e1);
        reun.iniciar();
        Thread.sleep(3000);
        reun.marcarAsistencia(e2);
        Thread.sleep(2000);
        reun.finalizar();
        System.out.println(reun.obtenerAusencias().size());
        System.out.println(reun.obtenerAtrasos());
        System.out.println(reun.obtenerAsistencia());
        System.out.println(reun.obtenerPorcentajeAsistencia());

    }
}