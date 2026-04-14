package Cola.colasimple;

import java.util.LinkedList;
import java.util.Queue;

public class ColaPedido {
    private Queue<Pedido> pedidos;

    public ColaPedido(){
        pedidos = new LinkedList<Pedido>();

    }

    public void encolar(Pedido p){
        pedidos.add(p);
    }

    public Pedido desencolar()throws Exception{
        if (pedidos.isEmpty()) {
            throw new Exception("No hay elementos en la cola"); // o lanzar una excepción
        }
        return pedidos.poll();
    }

    public Pedido primero()throws Exception{
        if (pedidos.isEmpty()) {
            throw new Exception("No hay elementos en la cola"); // o lanzar una excepción
        }
        return pedidos.peek();
    }

    //completar método faltante con el size y el toString

    public int size(){
        return pedidos.size();
    }

    @Override
    public String toString() {
        String resultado = "";
        for (Pedido p : pedidos) {
            resultado += p + "\n";
        }
        return resultado;
    }
}
