package org.tarea2;

/**
 * Nota es una clase que representa una nota asociada a una reunión.
 *
 * La clase contiene un atributo de texto que almacena el contenido de la nota.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Nota {
    private String texto;

    public Nota(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }

    @Override
    public String toString(){
        return "Nota: " + getTexto();
    }
}
