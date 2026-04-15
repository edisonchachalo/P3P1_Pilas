package Cola.colasimple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextField txtCantidad;
    private JButton agregarPedidoButton;
    private JButton despacharPedidoButton;
    private JButton próximoPedidoButton;
    private JButton totalesButton;
    private JButton pedidosPendientesButton;
    private JButton pedidosDespachadosButton;
    private JTextArea textArea1;

    //vamos a crear dos colas porque vamos a ver los pedidos realizados y los pedidos despachados

    private ColaPedido pedidos = new ColaPedido();
    private ColaPedido despachados = new ColaPedido();

    public Ventana(){

        agregarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //crear un objeto con el que se va a trabajar
                //vamos a crear variables auxiliares
                String codigo = txtCodigo.getText();
                String descripcion = txtDescripcion.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());

                //despues de sacar los textos, para evitar que la información sea cambiada, enviamos como parámetros
                pedidos.encolar(new Pedido(codigo, descripcion, cantidad));
                setear(); //llamamos al método setear para limpiar los campos de texto

                textArea1.setText("Pedido agergado\n"+pedidos.toString());

            }
        });
        despacharPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //primero mostrar el pedido que se va a despachar, luego lo enviamos a la cola de despachados
                    Pedido p = pedidos.desencolar();
                    despachados.encolar(p);

                    textArea1.setText("Pedido despachado\n"+p.toString());

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());

                }
            }
        });
        totalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pendientes = pedidos.size();
                int despachadosTotal = despachados.size();
                JOptionPane.showMessageDialog(null,"Totales\nPendientes: "+pendientes+"\nDespachados: "+despachadosTotal);
            }
        });
        próximoPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pedido p = pedidos.primero();
                    textArea1.setText("Próximo pedido a despachar\n"+p);
                }catch(Exception ex){
                    textArea1.setText("No hay pedidos en la cola");
                }
            }
        });
        pedidosPendientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pedidos.size() == 0) {
                    textArea1.setText("No hay pedidos pendientes");
                } else {
                    textArea1.setText("Pedidos pendientes\n"+pedidos.toString());
                }
            }
        });
        pedidosDespachadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(despachados.size()==0){
                    textArea1.setText("No hay pedidos despachados");
                }else{
                    textArea1.setText("Pedidos despachados\n"+despachados.toString());
                }
            }
        });
    }

    public void setear(){
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
