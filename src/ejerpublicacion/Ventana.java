package ejerpublicacion;

import ejerpilaint.Pila;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JButton btnEnviarMensaje;
    private JTextField txtMensaje;
    private JButton btnEliminar;
    private JButton btnUltimo;
    private JButton btnLike;
    private JTextArea textArea1;

    private PilaMensaje whatsApp;
    //crear un constructor por defecto para inicializar el objeto de tipo PilaMensaje, para que se pueda utilizar en los botones
    //si no creo el constructor por defecto no puedo colocar los eventos de los botones
    public Ventana(){
        //whatsApp = new PilaMensaje();

        btnEnviarMensaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mensaje mensaje = new Mensaje(txtMensaje.getText());
                whatsApp.push(mensaje);
                txtMensaje.setText("");
                textArea1.setText(whatsApp.toString());

            }
        });
    }
}
