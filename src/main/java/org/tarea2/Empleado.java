package org.tarea2;

/**
 * Clase que representa a un único empleado de la empresa.
 *
 * Implementa la interfaz Invitable, lo que permite invitar a un empleado específico a una reunión.
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;
    private Invitacion invitacion;

    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
        this.departamento.agregarEmpleado(this);
    }

    public Empleado(String nombre, String apellidos, String correo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    /**
     * Método que permite invitar a un único empleado a una reunión.
     *
     * @param reunion La reunión a la que se invitará al empleado.
     */
    @Override
    public void invitar(Reunion reunion) {
        reunion.agregarInvitado(this);
    }



    public String getId() { return id; }
    public String getApellidos() { return apellidos; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public Departamento getDepartamento() { return departamento; }

    @Override
    public String toString() {
        return "id = " + getId() + "\napellidos='" + getApellidos() + "\nnombre='" + getNombre() + "\ncorreo='" + getCorreo();
    }
}