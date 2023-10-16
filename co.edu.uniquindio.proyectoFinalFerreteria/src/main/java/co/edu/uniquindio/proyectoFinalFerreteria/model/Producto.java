package co.edu.uniquindio.proyectoFinalFerreteria.model;

public class Producto extends Persona
{
    private String id_Producto;

    public Producto(String nombre,
                    String apellido,
                    String cedula, int edad
                    ,String id_Producto)
    {
        super(nombre, apellido, cedula, edad);
        this.id_Producto = id_Producto;
    }

    public Producto()
    {

    }

    public String getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(String id_Producto) {
        this.id_Producto = id_Producto;
    }
}
