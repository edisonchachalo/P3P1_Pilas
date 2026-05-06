package busquedas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo {
    private List<Jugador> seleccion;

    public Equipo() {
        seleccion = new ArrayList<>();
    }

    public void cargarDatos() {
        seleccion.add(new Jugador(1, "Messi", 9.8, "Delantero", 50000));
        seleccion.add(new Jugador(2, "Cristiano", 9.5, "Delantero", 48000));
        seleccion.add(new Jugador(3, "Neymar", 8.7, "Extremo", 45000));
        seleccion.add(new Jugador(4, "Modric", 8.9, "Mediocampista", 40000));
        seleccion.add(new Jugador(5, "Casillas", 9.0, "Arquero", 42000));
    }

    //Por seguridad no recibo el objeto de la clase jugador, sino recibo los datos (atributos) del jugador
    // Si en el main tengo el objeto, puedo acceder a modificarlo, al hacerlo de esta manera se agrega una capa de seguridad para evitar cambios
    public void add(int codigo, String nombre, double rendimiento, String posicion, float sueldo) throws Exception{
        for (Jugador j : seleccion){
            if (j.getCodigo() == codigo){
                throw new Exception("Jugador con código "+j.getCodigo()+" ya se encuentra registrado.");
            }
        }
        seleccion.add(new Jugador(codigo,nombre,rendimiento,posicion,sueldo));
    }

    public List<Jugador> getSeleccion (){
        return seleccion;
    }

    //agregar los diferentes métodos de búsqueda
    //método de búsqueda lineal por nombre
    //incluir el método de búsqueda en la ventana para el botón busqueda lineal
    //inlcuir el método para setear los datos

    public Jugador busquedaLineal(String nombre) throws Exception {
        for (Jugador j : seleccion) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        throw new Exception("Jugador no encontrado.");
    }

    //búsqueda binaria, tenemos que ordenar primero a la lista
    // utilizamos collection.sort
    //realizar el método busquedaBinaria, realizar con las listas
    //al inicio, primero como instrucción ordenar la lista y luego hacer la búsqueda binaria
    // la búsqueda binaria se debe hacer
    // el compareTo debe ir ordenado en función del campo que quiero hacer la búsqueda binaria
    // hay que ordenar por rendimiento, luego de ordenar por rendimiento, enviar a realizar la búsqueda binaria

    public Jugador busquedaBinaria(double rendimientoBuscado) throws Exception {
        // primero Ordenar la lista por rendimiento usando el compareTo de la clase Jugador
        Collections.sort(seleccion);

        int inicio = 0;
        int fin = seleccion.size() - 1;

        // Búsqueda binaria
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Jugador jugadorMedio = seleccion.get(medio);

            if (jugadorMedio.getRendimiento() == rendimientoBuscado) {
                return jugadorMedio; // encontrado
            } else if (jugadorMedio.getRendimiento() < rendimientoBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        throw new Exception("Jugador con ese rendimiento no encontrado.");
    }




}

//interfaz gráfica similar a la de la corrección del examen
//colocar todos los datos del jugador
//posición combobox con todas las posiciones
//botón para agregar
//botón para busqueda lineal
//botón para busqueda binaria
//en vez de textArea un Jlist


/*public void cargarDatos() {
    seleccion.add(new Jugador(1, "Messi", 9.8, "Delantero", 50000));
    seleccion.add(new Jugador(2, "Cristiano", 9.5, "Delantero", 48000));
    seleccion.add(new Jugador(3, "Neymar", 8.7, "Extremo", 45000));
    seleccion.add(new Jugador(4, "Modric", 8.9, "Mediocampista", 40000));
    seleccion.add(new Jugador(5, "Casillas", 9.0, "Arquero", 42000));
}*/


