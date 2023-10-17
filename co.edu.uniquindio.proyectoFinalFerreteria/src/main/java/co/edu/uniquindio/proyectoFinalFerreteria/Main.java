package co.edu.uniquindio.proyectoFinalFerreteria;

import co.edu.uniquindio.proyectoFinalFerreteria.model.Ferreteria;
import jdk.jshell.execution.Util;

import static co.edu.uniquindio.proyectoFinalFerreteria.MainMenu.*;

public class Main
{
    /**
     * Metodo principal
     * @param args
     */
    public static void main(String[] args)
    {
        Ferreteria ferreteria=inicializarDatosPrueba();
        MainMenu.mostrarMenuPrincipal(ferreteria);

    }
}