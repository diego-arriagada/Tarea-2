package org.tarea2;

public class empleadoInvalidoException extends Exception {
    public empleadoInvalidoException() {
        super("El empleado ingresado no existe");
    }
}
