package org.tarea2;

import java.time.Duration;
import java.time.Instant;

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
