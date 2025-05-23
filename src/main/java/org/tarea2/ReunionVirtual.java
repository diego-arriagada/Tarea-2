package org.tarea2;

import java.time.Duration;
import java.time.Instant;

/**
 * ReunionVirtual hereda de Reunion y representa una reunión virtual con un enlace específico.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Instant fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo, Empleado organizador, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, tipo, organizador);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }
}
