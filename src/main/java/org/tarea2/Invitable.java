package org.tarea2;

/**
 * La interfaz Invitable provee un esqueleto para el metodo que invita individuos (empleados o externos) a una reunion.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public interface Invitable {
    /**
     * Método que permite invitar a un individuo a una reunión.
     *
     * @param reunion La reunión a la que se invitará al individuo.
     */
    void invitar(Reunion reunion);
}
