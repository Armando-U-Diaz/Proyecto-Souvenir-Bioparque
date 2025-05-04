package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Souvenirs extends JFrame implements ActionListener{
    // =====> A T R I B U T O S <=====
    protected JFrame ventana2;
    private JPanel lienzo2;
    private JPanel panelTicket;
    // Variables a utilizar
    public float total = 0;
    private int x = 1;
    private double costo = 0;
    // Caja de texto
    private JLabel txtNumerosNota;
    public JTextField txtPrecio;
    private JTextArea txtAreaTiket;    
    // Cajita de los productos en venta
    private JComboBox<String> comboSouvenir;
    // Botones
    private JButton aceptar1;
    private JButton cancelar1;
    private JButton agregar;
    private JButton calcularTotal;
    private JButton ventaNueva;
    // Etiquetas
    private JLabel nota;
    private JLabel souvenir;
    private JLabel precio;
    // Crear fonts para tipo de letras
    public Font fuente, fuente3, fuente4;
    public JScrollPane scrollTicket;

    public Souvenirs() {

        ventana2 = new JFrame("Compra de souvenirs");
        lienzo2 = new JPanel();
        
        String souvenirs[] = {"Gorro", "Taza", "Termo", "Llavero", "Peluche", "Playera", "Pulcera", "Espejo"};
        // Modificador de fuente
        fuente = new Font("Arial", Font.BOLD, 25);
        fuente3 = new Font("Arial", Font.BOLD, 20);
        fuente4 = new Font("Monospaced", Font.BOLD, 18);
        
        nota = new JLabel("            Nota: ");
        nota.setFont(fuente);
        nota.setForeground(new Color(154, 205, 50));
        
        souvenir = new JLabel("    Souvenirs:");
        souvenir.setFont(fuente);
        souvenir.setForeground(new Color(154, 205, 50));
        
        precio = new JLabel("          Precio:");
        precio.setFont(fuente);
        precio.setForeground(new Color(154, 205, 50));

        comboSouvenir = new JComboBox<>(souvenirs);
        comboSouvenir.setFont(new Font("Monospaced", Font.BOLD, 18));;

        txtNumerosNota = new JLabel("00" + x);
        txtNumerosNota.setFont(fuente3);
        
        txtPrecio = new JTextField("$" + costo);
        txtPrecio.setEditable(false);
        txtPrecio.setFont(fuente3);
        txtAreaTiket = new JTextArea("");
        txtAreaTiket.setText("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=\nSOUVENIR BIOPARQUE: Tienda Zafari\n" + "\t==>Tiket: 00" + this.x + "<==");
        txtAreaTiket = new JTextArea();
        txtAreaTiket.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Editar fonts del tiket
        txtAreaTiket.setEditable(false); // Para que no se pueda editar por el usuario
        scrollTicket = new JScrollPane(txtAreaTiket);
        
        agregar = new JButton("Agregar +");
        aceptar1 = new JButton("Aceptar");
        cancelar1 = new JButton("Cancelar");
        calcularTotal = new JButton("Sacar total");
        ventaNueva = new JButton("Nueva Compra");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
            // Implementacion de las ventanas
        // Principal Botones
        lienzo2.setLayout(new GridLayout(5, 2, 10, 10));
        lienzo2.setBackground(new Color(105, 105, 105));
        // Panel del Tiket
        panelTicket = new JPanel(new BorderLayout());

        // Agregando los botones y cajitas de texto en el panel
        lienzo2.add(nota);
        lienzo2.add(txtNumerosNota);

        lienzo2.add(souvenir);
        lienzo2.add(comboSouvenir);

        lienzo2.add(precio);
        lienzo2.add(txtPrecio);
        
        lienzo2.add(agregar);
        lienzo2.add(calcularTotal);
        
        lienzo2.add(aceptar1);
        lienzo2.add(cancelar1);     
        
        panelTicket.add(new JLabel("\tºº B I O P A R Q U E ºº"), BorderLayout.NORTH);
        panelTicket.add(scrollTicket, BorderLayout.CENTER);
        panelTicket.add(ventaNueva, BorderLayout.SOUTH);

        ventana2.setLayout(new BorderLayout());
        ventana2.add(lienzo2, BorderLayout.NORTH);
        ventana2.add(panelTicket, BorderLayout.CENTER);

        ventana2.setSize(500, 700);
        ventana2.setVisible(true);
        
        // Implemento las acciones para los botones
        aceptar1.addActionListener(this);
        cancelar1.addActionListener(this);
        agregar.addActionListener(this);
        calcularTotal.addActionListener(this);
        ventaNueva.addActionListener(this);
        
        txtAreaTiket.setText("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=\nSOUVENIR BIOPARQUE: Tienda Zafari\n" + "\t==>Tiket: 00" + this.x + "<==");
    }

    // Condiciones para los productos y definicion de los precios
    public double obtenerPrecio() {
        this.costo = 0;
        if (comboSouvenir.getSelectedItem() == "Gorro") {
            this.costo = 45.59;
            this.txtPrecio.setText("$" + this.costo);
            txtPrecio.setText((String) " $" + costo);
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
        // ACEPTAR
        if (evento.getSource().equals(aceptar1)) {
            JOptionPane.showMessageDialog(this, "Compra aceptada");
            System.exit(0);
        }// CANCELAR
        else if (evento.getSource().equals(cancelar1)) {
            System.exit(0);
        }// AGREGAR
        else if (evento.getSource() == agregar) {
        txtAreaTiket.append("\n" + comboSouvenir.getSelectedItem() + "\t$" + costo);
        total += costo;
        }// CALCULAR TOTAL
        else if(evento.getSource() == calcularTotal) {
            txtAreaTiket.append("\n" + "\tTotal: $" + total);
        } // VENTA NUEVA
        else if (evento.getSource() == ventaNueva) {
            JOptionPane.showMessageDialog(this, "Nueva compra");
            this.x ++;
            txtNumerosNota.setText("00" + this.x);
            txtAreaTiket.setText("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=\nSOUVENIR BIOPARQUE: Tienda Zafari\n" + "\t==>Tiket: 00" + this.x + "<==");
            total = 0;
        } // final de los if
    }
}
