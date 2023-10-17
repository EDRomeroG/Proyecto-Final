package co.edu.uniquindio.proyectoFinalFerreteria.model;

import javax.swing.*;

public class Empleado extends Persona
{
    private String id_Empleado;
    private TipoEmpleado tipoEmpleado;


    public Empleado()
    {
        super ();
    }

    public Empleado(String nombre, String apellido, String cedula, int edad, String id_Empleado, TipoEmpleado tipoEmpleado) {
        super(nombre, apellido, cedula, edad);
        this.id_Empleado = id_Empleado;
        this.tipoEmpleado = tipoEmpleado;
    }

    public String toString()
    {
        return "Cliente: " +"\n"+
                "Nombre: " + getNombre() +"\n"+
                "Apellido: " + getApellido() +"\n"+
                "Codigo  de empleado: " + id_Empleado +"\n"+
                "Edad: " + getEdad() ;
    }

    /**
     * Metodo para seleccionar el puesto del empleado
     * @return
     */
    public static TipoEmpleado seleccionarPuesto()
    {
        String[] opciones = {TipoEmpleado.VENDEDOR.toString(), TipoEmpleado.CAJERO.toString(), TipoEmpleado.ADMINISTRADOR.toString()};
        String puestoSeleccionado = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona tu puesto:",
                "Seleccionar Puesto",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        return TipoEmpleado.valueOf(puestoSeleccionado);
    }



}
