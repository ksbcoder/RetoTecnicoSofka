package concursopreguntas;

import java.util.ArrayList;
import java.util.List;
import concursopreguntas.entidades.Pregunta;
import concursopreguntas.entidades.Ronda;

/**
 *
 * @author kevin
 */
public class construirConcurso {

    private final List<Pregunta> preguntas;
    private boolean salida;

    public construirConcurso() {
        this.preguntas = new ArrayList();
    }

    public void agregarPregunta(Pregunta pAgregar) {
        this.preguntas.add(pAgregar);
    }

    public void preguntar(Ronda ronda) {
        if (ronda.getRonda() != 0 && ronda.getRonda() < 6) {
            int numero = (int) (Math.random() * preguntas.size());
            for (Pregunta pr : this.preguntas) {
                if (numero == this.preguntas.indexOf(pr) && pr.getNivel() == ronda.getRonda() && pr.getCategoria().getCategoria() == ronda.getRonda()) {
                    boolean acierta = pr.preguntar(numero);
                    if (acierta) {
                        System.out.println("¡Correcto!");
                        ronda.setRonda(ronda.getRonda() + 1);
//                        Resultados(ronda);
                        if (ronda.getRonda() == 6) {
                            System.out.println("¡Haz ganado!");
                            ronda.setRonda(0);
                        }
                    } else {
                        System.out.println("¡Incorrecto!");
                        this.salida = true;
                        ronda.setRonda(0);
                        Resultados(ronda);
                    }
                }
            }
        }
    }

    public void Resultados(Ronda ronda) {
        if (this.salida == true || ronda.getRonda() == 0) {
            ronda.setPuntaje(0);
            System.out.println("Tu puntaje total es: " + ronda.getPuntaje() + " :(");
            System.out.println("¡Gracias por participar! \n");
        } else {
            System.out.println("Tu puntaje acumulado es: " + ronda.getPuntaje() + " :)");
        }
    }
}
