package org.tarea2;

import java.time.Duration;
import java.time.Instant;

/**
 * ReunionPresencial hereda de Reunion y representa una reunión presencial con una sala específica.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Instant fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo, Empleado organizador, String sala) {
        super(fecha, horaPrevista, duracionPrevista, tipo, organizador);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }
}
