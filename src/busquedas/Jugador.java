package busquedas;

public class Jugador implements Comparable<Jugador>{
    private int codigo;
    private String nombre;
    private double rendimiento;
    private String posicion;
    private float sueldo;

    public Jugador(int codigo, String nombre, double rendimiento, String posicion, float sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rendimiento = rendimiento;
        this.posicion = posicion;
        this.sueldo = sueldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Codigo: "+codigo+"\nNombre: "+nombre+"\nRendimiento: "+rendimiento+
                "\nPosicion: "+posicion+"\nSueldo: "+sueldo;
    }

    /*@Override
    public int compareTo(Jugador o) {
        return Integer.compare(this.codigo,o.getCodigo());
    }*/

    @Override
    public int compareTo(Jugador o) {
        return Double.compare(this.rendimiento, o.getRendimiento());
    }
}

