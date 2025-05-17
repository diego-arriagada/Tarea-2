package org.tarea2;

import java.time.Duration;
import java.time.Instant;

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
