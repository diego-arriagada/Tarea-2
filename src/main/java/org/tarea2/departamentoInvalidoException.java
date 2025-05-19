package org.tarea2;

public class departamentoInvalidoException extends Exception {
    public departamentoInvalidoException() {
        super("El departamento ingresado no es válido o no existe");
    }
}
