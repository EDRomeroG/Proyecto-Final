package co.edu.uniquindio.proyectoFinalFerreteria;
import co.edu.uniquindio.proyectoFinalFerreteria.model.*;
import static co.edu.uniquindio.proyectoFinalFerreteria.constantes.FerreteriaConstantes.*;
import static co.edu.uniquindio.proyectoFinalFerreteria.util.CapturaDatosUtil.*;
import javax.swing.*;
import java.util.List;

public class MainMenu
{
    public static Ferreteria  inicializarDatosPrueba()
    {
        Ferreteria ferreteria = new Ferreteria();
        ferreteria.setNombre("Ferreteria Paco");

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

        Empleado empleado = new Empleado();
        empleado.setNombre("Valentina");
        empleado.setApellido("Perez");
        empleado.setCedula("1111");
        empleado.setEdad(28);
        empleado.setTipoEmpleado(TipoEmpleado.ADMINISTRADOR);
        ferreteria.getListaEmpleados().add(empleado);

        empleado.setNombre("Carlos");
        empleado.setApellido("Perez");
        empleado.setCedula("1112");
        empleado.setEdad(20);
        empleado.setTipoEmpleado(TipoEmpleado.CAJERO);
        ferreteria.getListaEmpleados().add(empleado);
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
                    (MENU_PRINCIPAL);
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
                        mostrarMensajeAlerta(DESEA_SALIR);
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta(OPCION_NO_VALIDA);
                        break;
                }
            }
            else
            {
                mostrarMensajeAlerta(NUMERO_NO_VALIDO);
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
                    (MENU_CLIENTES);
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
                        crearCliente(ferreteria);
                        break;
                    case 2:
                        //Read
                        mostrarInformacionClientes(ferreteria);
                        break;
                    case 3:
                        //Update
                        String cedulaC =JOptionPane.showInputDialog
                                (CEDULA_ACTUALIZAR);
                        actualizarCliente(cedulaC, ferreteria);
                        break;
                    case 4:
                        //Delete
                        String cedulaCliente = JOptionPane.showInputDialog
                                (CEDULA_ELIMINAR);
                        eliminarCliente(ferreteria, cedulaCliente);
                        JOptionPane.showMessageDialog
                                (null, "Lista Nueva despues de eliminar ");
                        mostrarInformacionEmpleados(ferreteria);
                        break;
                    case 5:
                        mostrarMenuPrincipal(ferreteria);
                        break;
                    case 6:
                        mostrarMensajeAlerta(DESEA_SALIR);
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta(OPCION_NO_VALIDA);
                        break;
                }
            }
            else
            {
            mostrarMensajeAlerta(NUMERO_NO_VALIDO);
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
                    (MENU_EMPLEADOS);
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
                        crearEmpleado(ferreteria);
                        break;
                    case 2:
                        //Read Empleado
                        mostrarInformacionEmpleados(ferreteria);
                        break;
                    case 3:
                        //Update Empleado
                        String cambio = JOptionPane.showInputDialog
                                (CEDULA_ACTUALIZAR);
                        actualizarDatosEmpleado(ferreteria, cambio);
                        break;
                    case 4:
                        //Delete Empleado
                        String cedulaEmpleado = JOptionPane.showInputDialog
                                (CEDULA_ELIMINAR);
                        eliminarEmpleado(ferreteria, cedulaEmpleado);
                        JOptionPane.showMessageDialog
                                (null, "Lista Nueva despues de eliminar ");
                        mostrarInformacionEmpleados(ferreteria);
                        break;
                    case 5:
                        mostrarMenuPrincipal(ferreteria);
                        break;
                    case 6:
                        mostrarMensajeAlerta(DESEA_SALIR);
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta(OPCION_NO_VALIDA);
                        break;
                }
            }
            else
            {
                mostrarMensajeAlerta(NUMERO_NO_VALIDO);
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
                    (MENU_PRODUCTOS);
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
                                (INGRESE_NOMBRE_PRODUCTO);
                        if (nombre == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }
                        String codigo = JOptionPane.showInputDialog
                                (INGRESE_CODIGO_PRODUCTO);
                        if (codigo == null)
                        {
                            continue; // Volver a mostrar el menú principal
                        }
                        if(ferreteria.verificarProductoExiste(codigo) == true)
                        {
                            crearObjeto(nombre, codigo, ferreteria);
                            JOptionPane.showMessageDialog
                                    (null, PRODUCTO_CREADO);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog
                                    (null, PRODUCTO_NO_CREADO);
                        }
                        break;
                    case 2:
                        //Read
                        mostrarInformacionProducto(ferreteria);
                        break;
                    case 3:
                        //Update
                        String codigo1 =JOptionPane.showInputDialog(CODIGO_ACTUALIZAR);
                        actualizarDatosObjeto(ferreteria, codigo1);
                        mostrarInformacionProducto(ferreteria);
                        break;
                    case 4:
                        //Delete
                        String codObjeto = JOptionPane.showInputDialog
                                (CODIGO_ELIMINAR);
                        eliminarObjeto(ferreteria, codObjeto);
                        JOptionPane.showMessageDialog
                                (null, "Lista Nueva despues de eliminar ");
                        mostrarInformacionProducto(ferreteria);
                        break;
                    case 5:
                        mostrarMenuPrincipal(ferreteria);
                        break;
                    case 6:
                        mostrarMensajeAlerta(DESEA_SALIR);
                        System.exit(0);
                        break;
                    default:
                        mostrarMensajeAlerta(OPCION_NO_VALIDA);
                        break;
                }
            }
            else
            {
                mostrarMensajeAlerta(NUMERO_NO_VALIDO);
            }
        }
    }
    //Clientes
    /**
     * Metodo para crear cliente con las condiciones si esta o no registrado
     * @param ferreteria
     */
    private static void crearCliente(Ferreteria ferreteria)
    {
        String nombre = JOptionPane.showInputDialog
                (INGRESE_NOMBRE_CLIENTE);
        if (nombre == null)
        {
            return;
        }
        String apellido = JOptionPane.showInputDialog
                (INGRESE_APELLIDO_CLIENTE);
        if (nombre == null)
        {
            return;
        }
        String cedula = JOptionPane.showInputDialog
                (INGRESE_CEDULA_CLIENTE);
        if (nombre == null)
        {
            return;
        }
        int edad =Integer.parseInt( JOptionPane.showInputDialog
                (INGRESE_EDAD_CLIENTE));
        int tipoCliente =Integer.parseInt(JOptionPane.showInputDialog
                ("Tipo de cliente: "+
                "\n"+"1. Natural"+
                "\n"+"2. juridico"+
                "\n"+"Seleccione una opcion:"));
        if(ferreteria.verificarClienteExiste(cedula) == true)
        {
            crearClientes(nombre, apellido, cedula,edad, tipoCliente, ferreteria);
            JOptionPane.showMessageDialog
                    (null, CLIENTE_CREADO);
        }
        else
        {
            JOptionPane.showMessageDialog
                    (null, CLIENTE_NO_CREADO);
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
    private static void crearClientes(String nombre,
                                     String apellido,
                                     String cedula,
                                     int edad,
                                     int tipoCliente,
                                     Ferreteria ferreteria)
    {
        ferreteria.crearCliente(nombre, apellido, cedula, edad,tipoCliente);
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
    // Empleados
    /**
     * Metodo para crear un empleado con las condiciones si esta o no registrado
     * @param ferreteria
     */
    private static void crearEmpleado(Ferreteria ferreteria)
    {
        String nombre = JOptionPane.showInputDialog
                (INGRESE_NOMBRE_EMPLEADO);
        if (nombre == null)
        {
            return;
        }
        String apellido = JOptionPane.showInputDialog
                (INGRESE_APELLIDO_EMPLEADO);
        if (nombre == null)
        {
            return;
        }
        String cedula = JOptionPane.showInputDialog
                (INGRESE_CEDULA_EMPLEADO);
        if (nombre == null)
        {
            return;
        }
        int edad =Integer.parseInt( JOptionPane.showInputDialog
                (INGRESE_EDAD_EMPLEADO));
        if(ferreteria.verificarEmpleadoExiste(cedula) == true)
        {
            crearEmpleados(nombre, apellido, cedula,edad, ferreteria);
            JOptionPane.showMessageDialog
                    (null, EMPLEADO_CREADO);
        }
        else
        {
            JOptionPane.showMessageDialog
                    (null, EMPLEADO_NO_CREADO);
        }
    }
    /**
     * Metodo para crear un Empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param ferreteria
     */
    private static void crearEmpleados(String nombre,
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
    private static void mostrarInformacionEmpleados(Ferreteria ferreteria)
    {
        List<Empleado> listaEmpleados = ferreteria.obtenerEmpleado();
        String ferreteriaNombre = ferreteria.getNombre();
        int totalLista = listaEmpleados.size();
        for (int i = 0; i < totalLista; i++)
        {
            Empleado empleado = listaEmpleados.get(i);
            JOptionPane.showMessageDialog(null,
                    "Empleados registrados:"+"\n"+
                            ferreteriaNombre+
                            "\n"+"\n"+
                            empleado.toString());
        }
    }
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
    //Productos
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
        String ferreteriaNombre=ferreteria.getNombre();
        int totalLista = listaProducto.size();
        for (int i = 0; i < totalLista; i++)
        {
            Producto producto = listaProducto.get(i);
            JOptionPane.showMessageDialog(null,
                    "Objetos registrados:"+"\n"+
                    ferreteriaNombre+"\n"+"\n"+producto.toString());
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
