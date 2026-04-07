package ejerpilaint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Binario {
    private JPanel Binario;
    private JTextField txtNumEntero;
    private JTextArea textArea1Binario;
    private JButton btnConvertir;

    private Pila numeroBinario;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Binario");
        frame.setContentPane(new Binario().Binario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Binario() {
        numeroBinario = new Pila();

        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumEntero.getText());
                    txtNumEntero.setText("");
                    while (numero > 0) {
                        int residuo = numero % 2;
                        numeroBinario.push(residuo);
                        numero = numero / 2;
                    }
                    textArea1Binario.setText("Número binario: " + numeroBinario.mostrarBinario());
                } catch (Exception ex) {
                    textArea1Binario.setText("Error: Ingrese un número entero válido");
                }
            }
        });

    }
}
