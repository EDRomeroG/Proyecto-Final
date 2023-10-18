package co.edu.uniquindio.proyectoFinalFerreteria.model;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static co.edu.uniquindio.proyectoFinalFerreteria.constantes.FerreteriaConstantes.*;

public class Ferreteria
{
    private String nombre;
    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado>listaEmpleados=new ArrayList<>();
    List<Producto>listaProducto = new ArrayList<>();
    List<Venta>listaVentas = new ArrayList<>();
    public Ferreteria() {}
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public List<Producto> getListaProducto() {
        return listaProducto;
    }
    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    /**
     * Metodo para crear un Cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return boolean
     */
    public boolean crearCliente(String nombre, String apellido, String cedula, int edad,int tipoCliente)
    {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setEdad(edad);
        cliente.asignarTipoCliente(tipoCliente);
        getListaClientes().add(cliente);
        return true;
    }
    /**
     * Metodo para obtener la lista de clientes
     * @return lista
     */
    public List<Cliente> obtenerClientes()
    {
        return  getListaClientes();
    }
    /**
     * Metodo para actualizar la edad de un cliente
     * @param cedula
     */
    public void actualizarCliente(String cedula)
    {
        for (int i = 0; i < getListaClientes().size(); i++)
        {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula))
            {
                String opcion = JOptionPane.showInputDialog(
                        "Que dato desea actualizar?\n" +
                                "1. Nombre\n" +
                                "2. Cedula\n" +
                                "3. Salir\n" +
                                "Seleccione una opcion:");
                switch (opcion)
                {
                    case "1":
                        String nombreNuevo = JOptionPane.showInputDialog
                                ("Ingrese el nuevo nombre:");
                        cliente.setNombre(nombreNuevo);
                        break;
                    case "2":
                        String cedulaNueva = JOptionPane.showInputDialog
                                ("Ingrese la nueva cedula:");
                        cliente.setCedula(cedulaNueva);
                        break;
                    case "3":
                        return;
                    default:
                        JOptionPane.showMessageDialog
                                (null, OPCION_NO_VALIDA);
                        break;
                }
            }
            else
            {
             JOptionPane.showMessageDialog(null,
                     "La cedula: "
                     +cedula+"\n"+" no se encontro");
             break;
            }
        }
    }
    /**
     * Metodo para eliminar un cliente de la lista
     * @param cedula
     */
    public void eliminarCliente(String cedula)
    {
        int totalLista= getListaClientes().size();
        for(int i =0; i<totalLista; i++)
        {
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula))
            {
                getListaClientes().remove(i);
                break;
            }
        }
    }
    /**
     * Metodo para crear  un empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    public boolean crearEmpleado(String nombre,
                                 String apellido,
                                 String cedula,
                                 int edad)
    {
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCedula(cedula);
        empleado.setEdad(edad);
        getListaEmpleados().add(empleado);
        return true;
    }
    /**
     * Metodo para mostrar los empleados
     * @return
     */
    public List<Empleado> obtenerEmpleado()
    {
        return getListaEmpleados();
    }
    /**
     * Metodo para actualizar un empleado
     * @param cedula
     */
    public void actualizarEmpleado(String cedula)
    {
        for (int i = 0; i < getListaEmpleados().size(); i++)
        {
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getCedula().equalsIgnoreCase(cedula))
            {
                String opcion = JOptionPane.showInputDialog(
                        "Que dato desea actualizar?\n" +
                                "1. Nombre\n" +
                                "2. Apellido\n" +
                                "3. cedula\n" +
                                "4. edad\n" +
                                "5. Salir\n" +
                                "Seleccione una opcion:");
                switch (opcion)
                {
                    case "1":
                        String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                        empleado.setNombre(nombreNuevo);
                        break;
                    case "2":
                        String apellidoNuevo = JOptionPane.showInputDialog("Ingrese el nuevo apellido:");
                        empleado.setApellido(apellidoNuevo);
                        break;
                    case "3":
                        String cedulaNueva = JOptionPane.showInputDialog("Ingrese la nueva cedula:");
                        empleado.setCedula(cedulaNueva);
                        break;
                    case "4":
                        int edadNueva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cedula:"));
                        empleado.setEdad(edadNueva);
                        break;
                    case "5":
                        JOptionPane.showMessageDialog
                                (null, "Saliendo del programa.");
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, OPCION_NO_VALIDA);
                        break;
                }
            }
        }
    }
    /**
     * Metodo para eliminar un Empleado
     * @param cedula
     */
    public void eliminarEmpleado(String cedula)
    {
        int totalLista= getListaEmpleados().size();
        for(int i =0; i<totalLista; i++)
        {
            Empleado empleado = getListaEmpleados().get(i);
            if(empleado.getCedula().equalsIgnoreCase(cedula))
            {
                getListaEmpleados().remove(i);
                break;
            }
        }
    }
    /**
     * Metodo para crear un objeto
     * @param nombre
     * @param codigo
     * @return
     */
    public boolean crearObjeto(String nombre, String codigo)
    {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setId_Producto(codigo);
        getListaProducto().add(producto);
        return true;
    }
    /**
     * Metodo para obtener la lista de Objetos
     * @return lista
     */
    public List<Producto> obtenerProductos()
    {
        return  getListaProducto();
    }
    /**
     * Metodo para Actualizar un Objeto
     * @param codigo opcion
     */
    public void actualizarProducto(String codigo)
    {
        for (int i = 0; i < getListaProducto().size(); i++)
        {
            Producto producto = getListaProducto().get(i);
            if (producto.getId_Producto().equalsIgnoreCase(codigo))
            {
                String opcion = JOptionPane.showInputDialog(
                        "Que dato desea actualizar?\n" +
                                "1. Nombre\n" +
                                "2. codigo\n" +
                                "3. Salir\n" +
                                "Seleccione una opcion:");
                switch (opcion)
                {
                    case "1":
                        String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                        producto.setNombre(nombreNuevo);
                        break;
                    case "2":
                        String cedulaNueva = JOptionPane.showInputDialog("Ingrese el nuevo codigo:");
                        producto.setId_Producto(cedulaNueva);
                        break;
                    case "3":
                        JOptionPane.showMessageDialog
                                (null, "Saliendo del programa.");
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, OPCION_NO_VALIDA);
                        break;
                }
            }
        }
    }
    /**
     * Metodo para eliminar un objeto
     * @param codObjeto
     */
    public void eliminarProducto(String codObjeto)
    {
        int totalLista= getListaClientes().size();
        for(int i =0; i<totalLista; i++)
        {
            Producto producto = getListaProducto().get(i);
            if(producto.getId_Producto().equalsIgnoreCase(codObjeto))
            {
                getListaProducto().remove(i);
                break;
            }
        }
    }
    /**
     * Metodo para verificar si un cliente esta o no registrado
     * @param cedula
     * @return
     */
    public boolean verificarClienteExiste(String cedula)
    {
        for(int i=0; i<getListaClientes().size(); i++)
        {
            Cliente cliente= getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula))
            {
                return false;
            }
        }
        return true;
    }
    /**
     * Metodo para verificar si un empleado esta o no registrado
     * @param cedula
     * @return
     */
    public boolean verificarEmpleadoExiste(String cedula)
    {
        for(int i=0; i<getListaEmpleados().size(); i++)
        {
            Empleado empleado= getListaEmpleados().get(i);
            if(empleado.getCedula().equalsIgnoreCase(cedula))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo para verificar si un Producto esta o no registrado
     * @param codigo
     * @return
     */
    public boolean verificarProductoExiste(String codigo)
    {
        for(int i=0; i<getListaProducto().size(); i++)
        {
            Producto producto= getListaProducto().get(i);
            if(producto.getCedula().equalsIgnoreCase(codigo))
            {
                return true;
            }
        }
        return false;
    }
}
