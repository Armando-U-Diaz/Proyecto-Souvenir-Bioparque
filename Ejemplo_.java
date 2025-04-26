import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo_ extends JFrame implements ActionListener{
    // =====> A T R I B U T O S <=====
    public String[] souvenirs;
    private double total = 0;
    private int x = 1;
    private double costo = 0;
    private JTextField txtNumerosNota;
    private JTextField txtPrecio;
    private JTextField txtTiket;

    private JComboBox<String> comboSouvenir;

    private JButton aceptar1;
    private JButton cancelar1;
    private JButton agregar;
    private JButton calcularTotal;
    private JButton ventaNueva;

    private JLabel nota;
    private JLabel souvenir;
    private JLabel precio;

    public Ejemplo_() {

        souvenirs = new String[] {"Productos", "Gorro", "Taza", "Termo", "Llavero", "Peluche", "Playera", "Pulcera", "Espejo"};

        nota = new JLabel("Nota: ");
        souvenir = new JLabel("Souvenirs");
        precio = new JLabel("Precio");

        comboSouvenir = new JComboBox<>(souvenirs);

        txtNumerosNota = new JTextField("00" + x);
        txtNumerosNota.setEditable(false);
        txtPrecio = new JTextField("$" + costo);
        //txtPrecio.setEditable(false);
        txtTiket = new JTextField();
        txtTiket.setEditable(false); // Para que no se pueda editar por el usuario

        agregar = new JButton("Agregar +");
        aceptar1 = new JButton("Aceptar");
        cancelar1 = new JButton("Cancelar");
        calcularTotal = new JButton("Sacar total");
        ventaNueva = new JButton("Nueva Compra");

        setTitle("Bioparque: Souvenir");
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2, 15, 15));
        panel.setBackground(Color.ORANGE);

        // Agregando los botones y cajitas de texto en el panel
        panel.add(nota);
        panel.add(txtNumerosNota);

        panel.add(souvenir);
        panel.add(comboSouvenir);

        panel.add(precio);
        panel.add(txtPrecio);

        panel.add(aceptar1);
        panel.add(calcularTotal);

        panel.add(agregar);
        panel.add(cancelar1);

        panel.add(txtTiket);

        panel.add(ventaNueva);

        add(panel, BorderLayout.CENTER);

        // Implemento las acciones para los botones
        aceptar1.addActionListener(this);
        cancelar1.addActionListener(this);
        agregar.addActionListener(this);
        calcularTotal.addActionListener(this);
        ventaNueva.addActionListener(this);
        comboSouvenir.addActionListener(this);
        System.out.println("\n#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
        System.out.println("\t°° B I O P A R Q U E °°");
        System.out.println("SOUVENIR BIOPARQUE: Tienda Zafari");
        System.out.println("\t\t==>Tiket: 00" + this.x + "<==");
    }

    // Condiciones para los productos y definicion de los precios
    public double obtenerPrecio() {
        this.costo = 0;
        if (comboSouvenir.getSelectedItem() == "Productos") {
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Gorro") {
            this.costo = 45.59;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Taza") {
            this.costo = 155.65;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Termo") {
            this.costo = 231.56;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Llavero") {
            this.costo = 63.99;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Peluche") {
            this.costo = 798.52;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Playera") {
            this.costo = 220.33;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Pulcera") {
            this.costo = 12.32;
            this.txtPrecio.setText("$" + this.costo);
        } else if (comboSouvenir.getSelectedItem() == "Espejo") {
            this.costo = 367.89;
            this.txtPrecio.setText("$" + this.costo);
        } else {
            this.txtPrecio.setText("$" + this.costo);
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        obtenerPrecio();
        // Condicion de cada uno de los botones
        if (evento.getSource().equals(aceptar1)) {
            txtPrecio.setText((String) " $" + costo);
        }
        else if (evento.getSource().equals(cancelar1)) {
            System.exit(0);
        }
        else if (evento.getSource() == agregar) {
            System.out.println(comboSouvenir.getSelectedItem() + "\t$" + costo);
            txtTiket.setText((String) comboSouvenir.getSelectedItem() + "\t$" + costo);
            total += costo;
        }
        else if(evento.getSource() == calcularTotal) {
            System.out.println("\t\tTotal: $" + total);
            System.exit(0);
        }
        else if (evento.getSource() == ventaNueva) {
            JOptionPane.showMessageDialog(this, "Nueva compra");
            this.x ++;
            txtNumerosNota.setText("00" + this.x);
            System.out.println("\n#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
            System.out.println("\t°° B I O P A R Q U E °°");
            System.out.println("SOUVENIR BIOPARQUE: Tienda Zafari");
            System.out.println("\t==>Tiket: 00" + this.x + "<==");
            total = 0;
            txtTiket.setText("Producto y Precio");
        } // final de los if
    }

    private String agregarProducto() {
        String seleccionado = (String) comboSouvenir.getSelectedItem();
        total += costo;
        txtPrecio.setText(String.valueOf(precio));
        return seleccionado;
    }

    public static void main(String[] args) {
        Ejemplo_ ejecuta = new Ejemplo_();
        ejecuta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
