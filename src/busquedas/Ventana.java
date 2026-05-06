package busquedas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox cmbPosicion;
    private JTextField txtRendimiento;
    private JTextField txtSueldo;
    private JButton btnAgregar;
    private JButton btnBusquedaLineal;
    private JButton btnBusquedaBinaria;
    private JList list1;

    private Equipo equipo;

    public Ventana(){
        equipo = new Equipo();
        equipo.cargarDatos();


        btnBusquedaLineal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    Jugador encontrado = equipo.busquedaLineal(nombre);

                    if (encontrado!=null){
                        JOptionPane.showMessageDialog(null, encontrado);
                    }

                    setear();


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    String nombre = txtNombre.getText();
                    double rendimiento = Double.parseDouble(txtRendimiento.getText());
                    String posicion = cmbPosicion.getSelectedItem().toString();
                    float sueldo = Float.parseFloat(txtSueldo.getText());
                    equipo.add(codigo,nombre,rendimiento,posicion,sueldo);

                    setear();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        btnBusquedaBinaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double rendimientoBuscado = Double.parseDouble(txtRendimiento.getText());
                    Jugador encontrado = equipo.busquedaBinaria(rendimientoBuscado);

                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, encontrado);
                    }

                    setear();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    //setear datos
    public void setear() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtRendimiento.setText("");
        txtSueldo.setText("");
        cmbPosicion.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
