package co.edu.uniquindio.proyectoFinalFerreteria.util;


import javax.swing.*;

public class CapturaDatosUtil
{
    /**
     * Metodo para verificar si un String es un numero o no
     * @param opcion
     * @return
     */
    public static boolean verificarOpcion(String opcion)
    {
        try
        {
            Integer.parseInt(opcion);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }


    /**
     * Metodo para mostrar una Alerta de cierre
     * @param mensaje
     * @return
     */
    public static int mostrarMensajeAlerta(String mensaje)
    {
        return JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Alerta!",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
    }


    public static String crearId(String id)
    {
        String codigo="";
        return codigo;

    }



}
