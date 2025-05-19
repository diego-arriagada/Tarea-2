package org.tarea2;

public class tipoReunionInvalidoException extends Exception {
    public tipoReunionInvalidoException() {
        super("El tipo de reunion que se intenta ingresar no existe");
    }
}
