package co.edu.uniquindio.proyectoFinalFerreteria;

import co.edu.uniquindio.proyectoFinalFerreteria.model.Cliente;
import co.edu.uniquindio.proyectoFinalFerreteria.model.Empleado;
import co.edu.uniquindio.proyectoFinalFerreteria.model.Ferreteria;
import co.edu.uniquindio.proyectoFinalFerreteria.model.Producto;
import static co.edu.uniquindio.proyectoFinalFerreteria.util.CapturaDatosUtil.*;
import javax.swing.*;
import java.util.List;


public class MainMenu
{
    public static Ferreteria  inicializarDatosPrueba()
    {
        Ferreteria ferreteria = new Ferreteria();

        ferreteria.setNombre("Prestamos UniQuindio");

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Arias");
        cliente.setCedula("1094");
        cliente.setEdad(25);
        ferreteria.getListaClientes().add(cliente);

        cliente = new Cliente();
        cliente.setNombre("Ana");
        cliente.setApellido("Perez");
        cliente.setCedula("1095");
        cliente.setEdad(28);
        ferreteria.getListaClientes().add(cliente);

        return ferreteria;
    }

    /**
     * Metodo para Iniciar la interaccion con el usuario (menu Principal)
     * @param ferreteria
     */
    public static void mostrarMenuPrincipal(Ferreteria ferreteria)
    {
        int opcion=0;

        while (opcion != 4)
        {
            String entrada = JOptionPane.showInputDialog
                    ("**** Menu Principal ****" + "\n" +
                            "1. Gestión de Clientes" + "\n" +
                            "2. Gestión de Empleados" + "\n" +
                            "3. Gestión de Objetos" + "\n" +
                            "4. Hacer Venta" + "\n" +
                            "5. Salir" + "\n" +
                            "Seleccione una Opcion");
            if (entrada == null)
            {
                // El usuario seleccionó "Cancelar" en el cuadro de diálogo
                continue; // Volver a mostrar el menú principal
            }
            if (verificarOpcion(entrada))
            {
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1:
                        // Llamar al menú de  clientes
                        mostrarMenuClientes(ferreteria);
                        break;
                    case 2:
                        // Llamar al menú de empleados
                        mostrarMenuEmpleados(ferreteria);
                        break;
                    case 3:
                        // Llamar al menú de Objetos
                        mostrarMenuObjetos(ferreteria);
                        break;
                    case 4:

                        break;
                    case 5:
                        mostrarMensajeAlerta("Esta seguro de desea sali de la aplicación");
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta("Opción no válida. Por favor, selecciona una opción válida.");
                        break;
                }
            }
            else
            {
                mostrarMensajeAlerta("Ingresa un número válido.");
            }
        }
    }

    /**
     * Metodo para Mostrar el menu de clientes
     * @param ferreteria
     */
    private static void mostrarMenuClientes(Ferreteria ferreteria)
    {
        int opcion =0;

        while(opcion != 6)
        {
            String entrada = JOptionPane.showInputDialog
                    ("**** Menu Clientes ****" + "\n" +
                            "1. Crear cliente" + "\n" +
                            "2. Mostrar clientes" + "\n" +
                            "3. Actualizar datos" + "\n" +
                            "4. Eliminar" + "\n" +
                            "5. Menu Anterior" + "\n" +
                            "6. Salir" + "\n" +
                            "Seleccione una Opcion");
            if (entrada == null)
            {
                continue; // Volver a mostrar el menú principal
            }
            if (verificarOpcion(entrada))
            {
                opcion = Integer.parseInt(entrada);

                switch (opcion)
                {
                    case 1:
                        //Create
                        String nombre = JOptionPane.showInputDialog
                                ("Ingresa el nombre del Cliente: ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }

                        String apellido = JOptionPane.showInputDialog
                                ("Ingresa el apellido del Cliente: ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }

                        String cedula = JOptionPane.showInputDialog
                                ("Ingresa la cedula del Cliente: ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }

                        int edad =Integer.parseInt( JOptionPane.showInputDialog
                                ("Ingresa la edad del Cliente: "));

                        if(ferreteria.verificarClienteExiste(cedula) == true)
                        {
                            crearCliente(nombre, apellido, cedula,edad, ferreteria);
                            JOptionPane.showMessageDialog
                                    (null, "Cliente ingresado correctamente.");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog
                                    (null, "El Cliente ya esta registrado con ese numero de cedula.");
                        }
                        break;
                    case 2:
                        //Read
                        mostrarInformacionClientes(ferreteria);
                        break;
                    case 3:
                        //Update
                        String cedulaC =JOptionPane.showInputDialog("ingrese la cedula");
                        actualizarCliente(cedulaC, ferreteria);
                        mostrarInformacionClientes(ferreteria);
                        break;
                    case 4:
                        //Delete
                        String cedulaCliente = JOptionPane.showInputDialog
                                ("Ingresa la cedula del empleado a eliminar: ");
                        eliminarCliente(ferreteria, cedulaCliente);
                        JOptionPane.showMessageDialog
                                (null, "Lista Nueva despues de eliminar ");
                        mostrarInformacionEmpleados(ferreteria);
                        break;
                    case 5:
                        mostrarMenuPrincipal(ferreteria);
                        break;
                    case 6:
                        mostrarMensajeAlerta("Esta seguro de desea sali de la aplicación");
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta("Opción no válida. Por favor, selecciona una opción válida.");
                        break;
                }
            }
            else
            {
            mostrarMensajeAlerta(" Ingresa un número válido.");
            }
        }
    }


    /**
     * Metodo para mostrar el menu de Empleados
     * @param ferreteria
     */
    private static void mostrarMenuEmpleados(Ferreteria ferreteria)
    {
        int opcion = 0;
        while (opcion !=6)
        {

            String entrada = JOptionPane.showInputDialog
                    ("**** Menu Empleado ****" + "\n" +
                            "1. Crear Empleado" + "\n" +
                            "2. Mostrar Empleados" + "\n" +
                            "3. Actualizar datos" + "\n" +
                            "4. Eliminar" + "\n" +
                            "5. Menu Anterior" + "\n" +
                            "6. Salir" + "\n" +
                            "Seleccione una Opcion");
            if (entrada == null)
            {
                continue; // Volver a mostrar el menú principal
            }
            if(verificarOpcion(entrada))
            {
                opcion = Integer.parseInt(entrada);
                switch (opcion)
                {
                    case 1:
                        //Create Empleado
                        String nombre = JOptionPane.showInputDialog
                                ("Ingresa el nombre del Empleado ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }
                        String apellido = JOptionPane.showInputDialog
                                ("Ingresa el apellido del Empleado: ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }
                        String cedula = JOptionPane.showInputDialog
                                ("Ingresa la cedula del Empleado: ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }
                        int edad =Integer.parseInt( JOptionPane.showInputDialog
                                ("Ingresa la edad del Empleado: "));



                        if(ferreteria.verificarEmpleadoExiste(cedula) == true)
                        {
                            crearEmpleado(nombre, apellido, cedula,edad, ferreteria);
                            JOptionPane.showMessageDialog
                                    (null, "Empleado ingresado correctamente.");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog
                                    (null, "El Empleado ya esta registrado con ese numero de cedula.");
                        }
                        break;
                    case 2:
                        //Read Empleado
                        JOptionPane.showMessageDialog
                                (null, "Empleados registrados:");
                        mostrarInformacionEmpleados(ferreteria);
                        break;
                    case 3:
                        //Update Empleado
                        String cambio = JOptionPane.showInputDialog
                                ("Ingresa cedula del Empleado a Actualizar: ");
                        actualizarDatosEmpleado(ferreteria, cambio);
                        break;
                    case 4:
                        //Delete Empleado
                        String cedulaEmpleado = JOptionPane.showInputDialog
                                ("Ingresa la cedula del empleado a eliminar: ");
                        eliminarEmpleado(ferreteria, cedulaEmpleado);
                        JOptionPane.showMessageDialog
                                (null, "Lista Nueva despues de eliminar ");
                        mostrarInformacionEmpleados(ferreteria);
                        break;
                    case 5:
                        mostrarMenuPrincipal(ferreteria);
                        break;
                    case 6:
                        mostrarMensajeAlerta("Esta seguro de desea sali de la aplicación");
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta("Opción no válida. Por favor, selecciona una opción válida.");
                        break;
                }
            }
            else
            {
                mostrarMensajeAlerta("Ingresa un número válido.");
            }

        }
    }




    /**
     * Metodo para mostrar el menu de Objetos
     * @param ferreteria
     */
    private static void mostrarMenuObjetos(Ferreteria ferreteria)
    {
        int opcion = 0;
        while (opcion!= 6)
        {
            String entrada = JOptionPane.showInputDialog
                    ("**** Menu Productos ****" + "\n" +
                            "1. Crear Producto" + "\n" +
                            "2. Mostrar Producto" + "\n" +
                            "3. Actualizar Producto " + "\n" +
                            "4. Eliminar Producto" + "\n" +
                            "5. Menu Anterior" + "\n" +
                            "6. Salir" + "\n" +
                            "Seleccione una Opcion");
            if (entrada == null)
            {
                continue; // Volver a mostrar el menú principal
            }

            if (verificarOpcion(entrada))
            {
                opcion = Integer.parseInt(entrada);
                switch (opcion)
                {

                    case 1:
                        //Create Objeto
                        String nombre = JOptionPane.showInputDialog
                                ("Ingresa el nombre del Producto: ");
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }
                        String codigo = JOptionPane.showInputDialog
                                ("Ingresa el codigo del Producto: ");
                        if (codigo == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }


                        if(ferreteria.verificarProductoExiste(codigo) == true)
                        {
                            crearObjeto(nombre, codigo, ferreteria);
                            JOptionPane.showMessageDialog
                                    (null, "Producto ingresado correctamente.");

                        }
                        else
                        {
                            JOptionPane.showMessageDialog
                                    (null, "El Cliente ya esta registrado con ese numero de cedula.");
                        }
                        break;
                    case 2:
                        //Read Objeto
                        JOptionPane.showMessageDialog
                                (null, "Objetos registrados:");
                        mostrarInformacionProducto(ferreteria);

                        break;
                    case 3:
                        //Update Objeto
                        String codigo1 =JOptionPane.showInputDialog("ingrese codigo del Objeto");
                        actualizarDatosObjeto(ferreteria, codigo1);
                        mostrarInformacionProducto(ferreteria);

                        break;
                    case 4:
                        //Delete Objeto
                        String codObjeto = JOptionPane.showInputDialog
                                ("Ingresa codigo del objeto a eliminar: ");
                        eliminarObjeto(ferreteria, codObjeto);
                        JOptionPane.showMessageDialog
                                (null, "Lista Nueva despues de eliminar ");
                        mostrarInformacionProducto(ferreteria);
                        break;
                    case 5:
                        mostrarMenuPrincipal(ferreteria);
                        break;
                    case 6:
                        mostrarMensajeAlerta("Esta seguro de desea sali de la aplicación");
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta("Opción no válida. Por favor, selecciona una opción válida.");
                        break;
                }
            }
            else
            {
                mostrarMensajeAlerta("Ingresa un número válido.");
            }
        }

    }


    /**
     * Metodo para crear un cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param ferreteria
     */
    private static void crearCliente(String nombre,
                                     String apellido,
                                     String cedula,
                                     int edad,
                                     Ferreteria ferreteria)
    {
        ferreteria.crearCliente(nombre, apellido, cedula, edad);

    }

    /**
     * Metodo para mostrar los clientes
     * @param ferreteria
     */
    private static void mostrarInformacionClientes(Ferreteria ferreteria)
    {
        List<Cliente> listaClientes = ferreteria.obtenerClientes();
        String prestamo = ferreteria.getNombre();
        int totalLista = listaClientes.size();
        for (int i = 0; i < totalLista; i++)
        {
            Cliente cliente = listaClientes.get(i);
            JOptionPane.showMessageDialog
                    (null,prestamo+"\n"+"\n"+cliente.toString());
        }
    }

    /**
     * Metodo para actualizar un cliente
     * @param cedula
     * @param ferreteria
     */
    private static void actualizarCliente(String cedula, Ferreteria ferreteria)
    {
        ferreteria.actualizarCliente(cedula);

    }

    /**
     * Metodo para eliminar un cliente
     * @param ferreteria
     * @param cedula
     */
    private static void eliminarCliente(Ferreteria ferreteria, String cedula)
    {
        ferreteria.eliminarCliente(cedula);

    }





    //creacion de Empleados

    /**
     * Metodo para crear un Empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param ferreteria
     */
    private static void crearEmpleado(String nombre,
                                      String apellido,
                                      String cedula,
                                      int edad,
                                      Ferreteria ferreteria)
    {
        ferreteria.crearEmpleado(nombre,apellido,cedula,edad);

    }

    /**
     * Metodo para mostrar los empleados
     * @param ferreteria
     */
    //read Empleado
    private static void mostrarInformacionEmpleados(Ferreteria ferreteria)
    {
        List<Empleado> listaEmpleados = ferreteria.obtenerEmpleado();
        String prestamo = ferreteria.getNombre();
        int totalLista = listaEmpleados.size();
        for (int i = 0; i < totalLista; i++)
        {
            Empleado empleado = listaEmpleados.get(i);
            JOptionPane.showMessageDialog(null,prestamo+"\n"+"\n"+empleado.toString());
        }

    }
    // Actualizacion de empleado

    /**
     * Metodo para actualizar un empleado
     * @param ferreteria
     * @param cedula
     */
    private static void actualizarDatosEmpleado
    (Ferreteria ferreteria, String cedula)
    {
        ferreteria.actualizarEmpleado(cedula);

    }
    //Eliminar Empleado

    /**
     * Metodo para eliminar un empleado
     * @param ferreteria
     * @param cedula
     */
    private static void eliminarEmpleado
    (Ferreteria ferreteria, String cedula)
    {
        ferreteria.eliminarEmpleado(cedula);

    }


    //creacion de objetos

    /**
     * Metodo para crear un objeto
     * @param nombre
     * @param codigo
     * @param ferreteria
     */
    private static void crearObjeto(String nombre,
                                    String codigo,
                                    Ferreteria ferreteria)
    {
        ferreteria.crearObjeto(nombre, codigo);

    }

    //Lectura de objetos

    /**
     * Metodo para mostrar los objetos
     * @param ferreteria
     */
    private static void mostrarInformacionProducto(Ferreteria ferreteria)
    {
        List<Producto> listaProducto = ferreteria.obtenerProductos();
        String prestamo=ferreteria.getNombre();
        int totalLista = listaProducto.size();
        for (int i = 0; i < totalLista; i++)
        {
            Producto producto = listaProducto.get(i);
            JOptionPane.showMessageDialog(null,prestamo+"\n"+"\n"+producto.toString());
        }


    }

    /**
     * Metodo para actualizar un objeto
     * @param ferreteria
     * @param cambio
     */
    private static void actualizarDatosObjeto
    (Ferreteria ferreteria, String cambio)
    {
        ferreteria.actualizarProducto(cambio);
    }

    /**
     * Metodo para eliminar un objeto
     * @param ferreteria
     * @param codObjeto
     */
    private static void eliminarObjeto(Ferreteria ferreteria, String codObjeto)
    {
        ferreteria.eliminarProducto(codObjeto);

    }


}
