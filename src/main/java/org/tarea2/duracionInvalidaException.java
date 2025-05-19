package org.tarea2;

public class duracionInvalidaException extends RuntimeException {
    public duracionInvalidaException() {
        super("Ingrese una duracion valida");
    }
}
