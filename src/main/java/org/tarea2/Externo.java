package org.tarea2;
/**
 * Clase que sirve para invitar a individuos externos a la empresa (no empleados).
 *
 * Hereda propiedades de la clase Empleado, pero solo las pertinentes.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Externo extends Empleado{

    public Externo(String nombre, String apellidos, String correo){
        super(nombre,apellidos,correo);
    }

    @Override
    public String toString(){
        return "nombre = " + getNombre() + "\napellidos='" + getApellidos() + "\ncorreo='" + getCorreo();
    }
}
