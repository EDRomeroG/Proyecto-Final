package co.edu.uniquindio.proyectoFinalFerreteria.model;

public class Cliente extends Persona
{




    public Cliente(String nombre, String apellido, String cedula, int edad)
    {
        super(nombre, apellido, cedula, edad);
    }

    public Cliente()
    {
        super();

    }

    @Override
    public String toString()
    {
        return "Cliente{" +
                "ownedByFerreteria=" + ownedByFerreteria +
                '}';
    }
}
