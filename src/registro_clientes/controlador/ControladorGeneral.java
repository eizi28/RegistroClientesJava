
package registro_clientes.controlador;

import java.util.Arrays;
import javax.swing.JOptionPane;

import registro_clientes.modelo.Cliente;
import registro_clientes.vista.VistaGeneral;

public class ControladorGeneral {

    private final VistaGeneral vista;

    public ControladorGeneral(VistaGeneral vista) {
        this.vista = vista;
        configurarEventos();
    }

    // CONECTAR LOS BOTONES CON SUS FUNCIONES
    private void configurarEventos() {

        vista.getBtnRegistrar().addActionListener(e -> registrar());

        vista.getBtnLimpiar().addActionListener(e -> limpiar());
    }

    // VALIDAR Y REGISTRAR LOS DATOS
    private void registrar() {

        int seleccion = vista.getCmbTipo().getSelectedIndex();

        String nombre = vista.getTxtNombre().getText().trim();
        String correo = vista.getTxtCorreo().getText().trim();

        char[] clave = vista.getTxtClave().getPassword();

        boolean aceptaTerminos = vista.getRbTerminos().isSelected();

        try {

            if (seleccion == 0) {
                mostrarError("Selecciona un tipo de cliente.");
                return;
            }

            if (nombre.isEmpty()) {
                mostrarError("Debes escribir tu nombre completo.");
                return;
            }

            if (correo.isEmpty()) {
                mostrarError("Debes escribir tu correo electronico.");
                return;
            }

            if (!correo.matches(
                    "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

                mostrarError("Ingresa un correo electronico valido.");
                return;
            }

            if (clave.length < 8) {
                mostrarError(
                    "La contraseña debe tener al menos 8 caracteres."
                );
                return;
            }

            if (!aceptaTerminos) {
                mostrarError(
                    "Debes aceptar los terminos y condiciones."
                );
                return;
            }

            String tipo = (String)
                    vista.getCmbTipo().getSelectedItem();

            // CREAR EL OBJETO CLIENTE
            Cliente cliente = new Cliente(tipo, nombre, correo);

            String mensaje =
                    "Registro completado correctamente.\n\n"
                    + "Tipo: " + cliente.getTipoCliente()
                    + "\nNombre: " + cliente.getNombre()
                    + "\nCorreo: " + cliente.getCorreo();

            JOptionPane.showMessageDialog(
                vista,
                mensaje,
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );

            limpiar();

        } finally {

            // BORRAR LA CONTRASEÑA DEL ARREGLO TEMPORAL
            Arrays.fill(clave, '\0');
        }
    }

    // LIMPIAR TODOS LOS CAMPOS
    private void limpiar() {

        vista.getCmbTipo().setSelectedIndex(0);

        vista.getTxtNombre().setText("");
        vista.getTxtCorreo().setText("");
        vista.getTxtClave().setText("");

        vista.getRbTerminos().setSelected(false);

        vista.getTxtNombre().requestFocusInWindow();
    }

    // MOSTRAR MENSAJES DE ERROR
    private void mostrarError(String mensaje) {

        JOptionPane.showMessageDialog(
            vista,
            mensaje,
            "Datos incorrectos",
            JOptionPane.WARNING_MESSAGE
        );
    }
}
