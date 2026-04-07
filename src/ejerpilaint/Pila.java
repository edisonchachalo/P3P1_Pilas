package ejerpilaint;

import java.util.Stack;

public class Pila {
    private Stack<Integer> pila;

    public Pila() {//constructor por defecto
        pila = new Stack<Integer>();

    }

    public Stack<Integer> getPila() {
        return pila;
    }
    //Operaciones
    //pop, push, peek, isEmpty, search

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public void push(Integer i) {
        pila.push(i); //si tengo una condicion especial, como no haber numero repetido. En el push debo hacer las validaciones solicitadas
    }

    public Integer pop() throws Exception {
        //validar primero que haya elementos
        if (isEmpty()) {
            throw new Exception("La pila esta vacia");
        }
        return pila.pop();
    }

    public Integer peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("La pila esta vacia");
        }
        return pila.peek();
    }

    public Integer search(Integer i) throws Exception {
        if (isEmpty()) {
            throw new Exception("Pila esta vacia");
        }
        return pila.search(i);
    }

    @Override
    public String toString() {
        String resultado = "Pila: \n";
        for (int i = pila.size() - 1; i >= 0; i--) {
            resultado += pila.get(i) + "\n";
        }
        return resultado;
    }

}
