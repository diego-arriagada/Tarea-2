package org.tarea2;

public class horarioInvalidoException extends Exception {
    public horarioInvalidoException(String mensaje) {
        super(mensaje);
    }//Esta excepcion se puede usar para horarios nulos o para cuando la hora de fin es antes que la hora de inicio programada
}    // x eso se usa el String mensaje, en caso de necesitar personalizarlo dependiendo de cual sea el motivo de la excepcion
