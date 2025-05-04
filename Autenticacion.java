import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Font;

// Importamos el paquete datoUsuario con los datos de contraseña y nombre
import datoUsuario.InformacionUsuario;

// importamos archivo de nueva ventana
import ventanas.Souvenirs;

// Clase princial
public class Autenticacion extends JFrame implements ActionListener{
    public Font fuent;
    public Font fuente2;
    public JButton aceptar;
    private JButton cancelar;
    protected JFrame ventana;
    private JLabel lblUser, lblPass;
    protected JTextField txtUser;
    protected JPasswordField contra;
    private JPanel lienzo;
    protected byte x = 3;
    protected boolean resp;
    
    // Se crea un objeto para invocar nombre y contraseña
    public InformacionUsuario dat;

    // Constructor
    public Autenticacion (){
        fuent = new Font("Arial", Font.BOLD, 25);
        fuente2 = new Font("Arial", Font.BOLD, 20);
        
        super("AUTENTICACION DE USUARIO");
        // OBJETOS A USAR
        ventana = new JFrame("Inicio de sesion");
        lienzo = new JPanel();
        
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener((ActionListener)this);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener((ActionListener)this);
        
        lblUser = new JLabel("         Usuario:");
        lblUser.setFont(fuent);
        lblUser.setForeground(new Color(154, 205, 50));
        
        lblPass = new JLabel("   Contraseña:");
        lblPass.setFont(fuent);
        lblPass.setForeground(new Color(154, 205, 50));
        
        txtUser = new JTextField(15);
        txtUser.setFont(fuente2);
        
        contra = new JPasswordField(15);
        contra.setFont(fuente2);
        
        dat = new InformacionUsuario();

        // Definiendo propiedades del panel y se agregan los elementos a el
        lienzo.setLayout(new GridLayout(3, 2, 15, 15));
        lienzo.setBackground(new Color(105, 105, 105));
        
        lienzo.add(lblUser);
        lienzo.add(txtUser);
        
        lienzo.add(lblPass);
        lienzo.add(contra);
        
        lienzo.add(aceptar);
        lienzo.add(cancelar);

        // Se agrega panel al Frame y propiedades del frame
        ventana.add(lienzo, BorderLayout.CENTER);
        ventana.setVisible(true);
        ventana.setSize(400, 200);
    }

    public static void main(String args[]) {
        Autenticacion vent = new Autenticacion();
        vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Class Acciones Extends Autenticacion
    private boolean evaluacion(){
        //byte x = 0, y;
        String user = txtUser.getText();
        String pass = contra.getText();

        return user.equals(dat.nombre) && pass.contentEquals(dat.contraseña);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource().equals(aceptar)) {
            resp = evaluacion();
            // Evaluacion de usuario o contraseña
            if (resp == false) {
                // Intentos al tenr errores
                JOptionPane.showMessageDialog(this, "Contraseña o Ususario incorrecto. Intntos resanetes: " + x);
                while (x > 0) {
                    txtUser.setText("");
                    contra.setText("");
                    x --;
                    System.load(String.valueOf(evaluacion()));
                }
                JOptionPane.showMessageDialog(this, "Muchos intentos fallidos.");
                System.out.println("Vueva a intentarlo mas tarde.");
                System.exit(0);

            } else {
                // Llamada  al nuevo metodo y minimizacion de esta ventana
                ventana.setVisible(false);
                JOptionPane.showMessageDialog(this, "Hola bienvenido de nuevo " + dat.nombre);
                
                // Mandar a llamar el Formulario de Souvenirs
                Souvenirs ejecuta = new Souvenirs();
                //ejecuta.sacaFactura(NORMAL);
                ejecuta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        }
        else if (ev.getSource().equals(cancelar)) {
            JOptionPane.showMessageDialog(this, "Hasta pronto");
            System.exit(0);
        }
    }

}
