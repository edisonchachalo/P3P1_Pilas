package ejerpublicacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
    private String texto;
    private LocalDateTime fecha;
    private int likes;

    public Mensaje(String texto) {
        this.texto = texto;
        fecha = LocalDateTime.now();
        likes = 0;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getLikes() {
        return likes;
    }

    public void addLikes(){
        likes++;
    }

    @Override
    public String toString() {
        return "Mensaje: " + texto +
                "\nFecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                "\nLikes: " + likes ;
    }
}
