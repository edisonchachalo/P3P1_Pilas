package ejerpublicacion;

import java.util.Stack;

public class PilaMensaje {
    private Stack<Mensaje> pila;

    public PilaMensaje() {//constructor por defecto
        pila = new Stack<Mensaje>();

    }

    public Stack<Mensaje> getPila() {
        return pila;
    }
    //Operaciones
    //pop, push, peek, isEmpty, search

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public void push(Mensaje i) {
        pila.push(i); //si tengo una condicion especial, como no haber numero repetido. En el push debo hacer las validaciones solicitadas
    }

    //pop y peek debe retornar un mensaje

    public Mensaje pop() throws Exception {
        //validar primero que haya elementos
        if (isEmpty()) {
            throw new Exception("La pila esta vacia");
        }
        return pila.pop();
    }

    public Mensaje peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("La pila esta vacia");
        }
        return pila.peek();
    }

    @Override
    public String toString() {
        String mensajeEnviado = " ";
        for (int i = 0; i < pila.size(); i++) {
            mensajeEnviado += pila.get(i)+"\n";
        }
        return mensajeEnviado;
    }

}
