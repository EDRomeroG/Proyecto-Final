package co.edu.uniquindio.proyectoFinalFerreteria.model;
public class Cliente extends Persona
{
     TipoCliente tipoCliente;
    public Cliente(String nombre, String apellido, String cedula, int edad)
    {
        super(nombre, apellido, cedula, edad);
    }
    public Cliente()
    {
        super();
    }
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    @Override
    public String toString()
    {
        return "Cliente: " +"\n"+
                "Nombre: " + getNombre() +"\n"+
                "Apellido: " + getApellido() +"\n"+
                "Cedula:   " + getCedula() +"\n"+
                "Edad:    " + getEdad() ;
    }
    public void asignarTipoCliente(int opcion)
    {
        if (opcion==1)
        {
            tipoCliente=TipoCliente.NATURAL;
        }
        else if(opcion==2)
        {
         tipoCliente=TipoCliente.JURIDICO;
        }
    }
}
