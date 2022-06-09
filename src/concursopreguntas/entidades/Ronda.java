package concursopreguntas.entidades;

/**
 *
 * @author kevin
 */
public class Ronda {

    private int ronda;
    private int puntaje;

    public Ronda(int ronda) {
        this.ronda = ronda;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
