package Cola.colasprioridad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JTextField txtNombre;
    private JTextField txtSintoma;
    private JComboBox cmbPrioridad;
    private JButton ingresarButton;
    private JButton atenderButton;
    private JButton proximoButton;
    private JList list1;
    private JPanel Ventana;

    //creamo objeto de SalaEmergencia para poder utilizar sus métodos en los botones
    private SalaEmergencia emergencia;

    //la lista solo funciona con un objeto de tipo DefaultListModel, por lo tanto vamos a crear un objeto de ese tipo para poder mostrar los pacientes en la lista
    private DefaultListModel dlm = new DefaultListModel<>(); //obligatorio para usar el Jlist

    //constructor por defecto para inicializar los objetos de tipo SalaEmergencia y DefaultListModel, para que se puedan utilizar en los botones
    public Ventana(){
        emergencia = new SalaEmergencia();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre, sintomas;
                int prioridad;
                nombre = txtNombre.getText();
                sintomas = txtSintoma.getText();
                //todo lo que tengo como control, retorna como entero
                prioridad = Integer.parseInt(cmbPrioridad.getSelectedItem().toString());
                emergencia.encolar(new Paciente(nombre, sintomas, prioridad));
                mostrar(); //método
            }
        });
    }

    public void setear(){
        txtNombre.setText("");
        txtSintoma.setText("");
        cmbPrioridad.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //como utilizar el dlm
    public void mostrar(){
        //para mostrar vamos a traer la lista de salaEmergencia, no puedo poner el mismo nombre, debo porner otro nombre auxiliar a la lista
        dlm.removeAllElements();
        List<Paciente> aux = emergencia.listar();
        //pedir que ordene la lista
        Collections.sort(aux);
        //para mostrar hacemos un for de colección
        for(Paciente p : aux){
            dlm.addElement(p);
        }
        list1.setModel(dlm);
    }
}
