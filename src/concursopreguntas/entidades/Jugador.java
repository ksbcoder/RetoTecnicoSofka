package concursopreguntas.entidades;

/**
 *
 * @author kevin
 */
public class Jugador {

    private String nombre;
    private int puntajeTotal;

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
}
