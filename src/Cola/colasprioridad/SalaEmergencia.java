package Cola.colasprioridad;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//clase cola prioridad
public class SalaEmergencia {
    PriorityQueue<Paciente> pacientes;
    //constructor por defecto
    public SalaEmergencia(){
        pacientes = new PriorityQueue<Paciente>();
    }

    public void encolar(Paciente p){
        pacientes.add(p);
    }

    public Paciente desencolar()throws Exception{
        if (pacientes.isEmpty()) {
            throw new Exception("No hay pacientes en la sala de emergencia"); // o lanzar una excepción
        }
        return pacientes.poll();
    }

    public Paciente primero()throws Exception{
        if (pacientes.isEmpty()) {
            throw new Exception("No hay pacientes en la sala de emergencia"); // o lanzar una excepción
        }
        return pacientes.peek();
    }

    //para imprimir vamos a retornar una lista
    public List<Paciente> listar(){
        return new ArrayList<>(pacientes);
        
    }


}
