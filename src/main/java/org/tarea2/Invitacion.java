package org.tarea2;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant horaInvitacion;
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
