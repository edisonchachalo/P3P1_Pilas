package ejerpilaint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JTextField txtNumero;
    private JButton btnApilar;
    private JButton btnDesapilar;
    private JButton btnCima;
    private JButton btnBuscar;
    private JTextArea textArea1;

    private Pila pilaNumeros;

    //hay que crear el atributo de tipo Pila y solo vamos a crear un objeto no una colección porque en la clase pila se están haciendo todas las operaciones

    public Ventana() {
        pilaNumeros = new Pila();
        btnApilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //el formulario siempre lee como texto, hay que hacer las conversiones necesarias para obtener los números
                pilaNumeros.push(Integer.parseInt(txtNumero.getText()));
                txtNumero.setText(""); //para que el espacio en txtNumero quede vacio despues de Apilar
                textArea1.setText(pilaNumeros.toString());
            }
        });
        btnDesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer numeroDesapilado = pilaNumeros.pop();
                    txtNumero.setText("");
                    textArea1.setText(numeroDesapilado+" desapilado \n" + pilaNumeros.toString());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        btnCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer numeroCima = pilaNumeros.peek();
                    txtNumero.setText("");
                    textArea1.setText("Cima: " + numeroCima + "\n" + pilaNumeros.toString());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtNumero.getText().isEmpty()){
                        textArea1.setText("Ingrese un número para buscar \n");
                        return;
                    }
                    Integer numeroBuscado = Integer.parseInt(txtNumero.getText());
                    int posicion = pilaNumeros.search(numeroBuscado);
                    txtNumero.setText("");
                    if (posicion==-1){
                        textArea1.setText("Dato no encontrado en la pila\n"+pilaNumeros.toString());
                    }else {
                        textArea1.setText("Número: "+numeroBuscado+" encontrado en la posición: "+posicion+"\n"+pilaNumeros.toString());
                    }
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
