
package registro_clientes.modelo;

public class Cliente {

    private final String tipoCliente;
    private final String nombre;
    private final String correo;

    public Cliente(String tipoCliente, String nombre, String correo) {
        this.tipoCliente = tipoCliente;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
