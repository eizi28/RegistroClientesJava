
package registro_clientes.vista;

import java.awt.*;
import javax.swing.*;

public class VistaGeneral extends JFrame {

    // Widgets del formulario
    private final JComboBox<String> cmbTipo = new JComboBox<>(
        new String[]{
            "Seleccione un tipo",
            "Persona Natural",
            "Corporativo",
            "Cliente",
            "Trabajador"
        }
    );

    private final JTextField txtNombre = new JTextField();
    private final JTextField txtCorreo = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();

    private final JRadioButton rbTerminos =
            new JRadioButton("Acepto los terminos y condiciones");

    private final JButton btnRegistrar =
            new JButton("Registrar");

    private final JButton btnLimpiar =
            new JButton("Limpiar");

    // Colores
    private final Color azul = new Color(40, 75, 145);
    private final Color fondo = new Color(241, 245, 251);
    private final Color texto = new Color(45, 55, 75);

    public VistaGeneral() {

        setTitle("Registro de Clientes");
        setSize(650, 490);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        construirVentana();
    }

    private void construirVentana() {

        JPanel principal = new JPanel(new BorderLayout(15, 20));
        principal.setBackground(fondo);
        principal.setBorder(
            BorderFactory.createEmptyBorder(25, 35, 25, 35)
        );

        // Encabezado
        JPanel encabezado = new JPanel(new GridLayout(2, 1, 0, 5));
        encabezado.setOpaque(false);

        JLabel titulo = new JLabel(
            "REGISTRO DE CLIENTES",
            SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setForeground(azul);

        JLabel subtitulo = new JLabel(
            "Complete los datos para realizar su registro",
            SwingConstants.CENTER
        );

        subtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitulo.setForeground(texto);

        encabezado.add(titulo);
        encabezado.add(subtitulo);
        principal.add(encabezado, BorderLayout.NORTH);

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(4, 2, 12, 18));
        formulario.setBackground(Color.WHITE);
        formulario.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        agregarCampo(formulario, "Tipo de cliente:", cmbTipo);
        agregarCampo(formulario, "Nombre completo:", txtNombre);
        agregarCampo(formulario, "Correo electronico:", txtCorreo);
        agregarCampo(formulario, "Contrasena:", txtClave);

        JPanel centro = new JPanel(new BorderLayout(10, 15));
        centro.setOpaque(false);
        centro.add(formulario, BorderLayout.CENTER);

        rbTerminos.setBackground(fondo);
        rbTerminos.setFont(new Font("Arial", Font.PLAIN, 13));
        rbTerminos.setForeground(texto);
        rbTerminos.setHorizontalAlignment(SwingConstants.CENTER);

        centro.add(rbTerminos, BorderLayout.SOUTH);
        principal.add(centro, BorderLayout.CENTER);

        // Botones
        JPanel botones = new JPanel(new GridLayout(1, 2, 15, 0));
        botones.setOpaque(false);

        personalizarBoton(btnRegistrar, azul, Color.WHITE);
        personalizarBoton(
            btnLimpiar,
            new Color(210, 220, 235),
            texto
        );

        botones.add(btnRegistrar);
        botones.add(btnLimpiar);

        principal.add(botones, BorderLayout.SOUTH);

        setContentPane(principal);
    }

    private void agregarCampo(
            JPanel panel, String nombre, JComponent componente) {

        JLabel etiqueta = new JLabel(nombre);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 13));
        etiqueta.setForeground(texto);

        componente.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(etiqueta);
        panel.add(componente);
    }

    private void personalizarBoton(
            JButton boton, Color fondoBoton, Color colorTexto) {

        boton.setBackground(fondoBoton);
        boton.setForeground(colorTexto);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );
        boton.setPreferredSize(new Dimension(150, 43));
    }

    // Metodos para el controlador general

    public JComboBox<String> getCmbTipo() {
        return cmbTipo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JPasswordField getTxtClave() {
        return txtClave;
    }

    public JRadioButton getRbTerminos() {
        return rbTerminos;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }
}
