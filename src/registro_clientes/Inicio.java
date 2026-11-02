
package registro_clientes;

import javax.swing.SwingUtilities;

import registro_clientes.vista.VistaGeneral;
import registro_clientes.controlador.ControladorGeneral;

public class Inicio {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VistaGeneral vista = new VistaGeneral();

            new ControladorGeneral(vista);

            vista.setVisible(true);
        });
    }
}
