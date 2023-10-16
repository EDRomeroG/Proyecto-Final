package co.edu.uniquindio.proyectoFinalFerreteria.model;

public class Empleado extends Persona
{
    private String id_Empleado;


    public Empleado()
    {
        super ();
    }

    public Empleado(String nombre, String apellido, String cedula, int edad)
    {
        super(nombre, apellido, cedula, edad);
    }


}
