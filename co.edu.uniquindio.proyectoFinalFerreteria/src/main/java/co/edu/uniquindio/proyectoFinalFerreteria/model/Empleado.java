package co.edu.uniquindio.proyectoFinalFerreteria.model;
import javax.swing.*;

import static co.edu.uniquindio.proyectoFinalFerreteria.constantes.FerreteriaConstantes.*;

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
    public String getId_Empleado() {
        return id_Empleado;
    }
    public void setId_Empleado(String id_Empleado) {
        this.id_Empleado = id_Empleado;
    }
    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    public String toString()
    {
        return "Cliente: " +"\n"+
                "Nombre: " + getNombre() +"\n"+
                "Apellido: " + getApellido() +"\n"+
                "Codigo  de empleado: " + id_Empleado +"\n"+
                "Edad:   " + getEdad() ;
    }
    /**
     * Metodo para seleccionar el puesto del empleado
     * @return
     */
    public void asignarTipoEmpleado(int opcion)
    {
        if (opcion==1)
        {
            tipoEmpleado=TipoEmpleado.CAJERO;
        }
        else if(opcion==2)
        {
            tipoEmpleado=TipoEmpleado.ADMINISTRADOR;
        }
        else if(opcion==3)
        {
            tipoEmpleado=TipoEmpleado.VENDEDOR;
        }
        else
        {
         JOptionPane.showMessageDialog(null,OPCION_NO_VALIDA);
        }
    }
}
