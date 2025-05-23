package org.tarea2;
import java.time.Instant;

/**
 * Invitación representa una invitación a una reunión.
 *
 * Utiliza un tipo genérico T para permitir que tanto un empleado como un departamento puedan ser invitados a una reunión.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Invitacion {
    private Instant horaInvitacion;

    /**
     * Constructor de la clase Invitacion.
     *
     * @param reunion La reunión a la que se está invitando.
     * @param remitente El remitente de la invitación, que puede ser un empleado o un departamento.
     */
    public <T> Invitacion(Reunion reunion,T remitente){
        this.horaInvitacion = Instant.now();
        if(remitente instanceof Empleado) {
            ((Empleado)remitente).invitar(reunion);
        }
        else if(remitente instanceof Departamento){
            ((Departamento)remitente).invitar(reunion);
        }
    }
}
