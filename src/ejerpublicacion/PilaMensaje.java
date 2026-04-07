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
        String resultado = "Pila: \n";
        for (int i = pila.size() - 1; i >= 0; i--) {
            resultado += pila.get(i) + "\n";
        }
        return resultado;
    }

    public String mostrarBinario(){
        String resultado = " ";
        for (int i = pila.size() - 1; i >= 0; i--) {
            resultado += pila.pop(); //no utilizamos get porque si ponemos otro número se va a mostrar el mismo número, entonces con pop se muestra el número y se elimina de la pila, entonces cada vez que se muestre el número binario se va a eliminar el número de la pila con pop
        }
        return resultado;
    }
}
