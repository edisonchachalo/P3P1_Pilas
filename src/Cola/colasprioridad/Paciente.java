package Cola.colasprioridad;
//implements Comparable<lo que voy a comparar>
public class Paciente implements Comparable<Paciente>{
    //atributos
    private String nombre;
    private String sintoma;
    private int prioridad;
    //constructor


    public Paciente(String nombre, String sintoma, int prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\n Sintoma: " + sintoma +
                "\n Prioridad: " + prioridad;
    }

    @Override
    public int compareTo(Paciente p) {
        //retorna un numero negativo si this es menor que p, 0 si son iguales, y un numero positivo si this es mayor que p
        // return Integer.compare(this.prioridad,p.getPrioridad());

        //para hacer manual con un if, es decir cuando debo ordenar de acuerdo a mi prioridad o a lo que se necesite
        if(this.prioridad > p.getPrioridad()){
            return 1;
        }else {
            return -1;
        }
    }


}
