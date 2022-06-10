package concursopreguntas;

import concursopreguntas.entidades.Jugador;
import java.util.ArrayList;
import java.util.List;
import concursopreguntas.entidades.Pregunta;
import concursopreguntas.entidades.Ronda;
import db.DB;
import java.util.Scanner;

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

    public void preguntar(Ronda ronda, Jugador jugador) {
        if (ronda.getRonda() != 0 && ronda.getRonda() < 6) {
            int numero = (int) (Math.random() * preguntas.size());
            for (Pregunta pr : this.preguntas) {
                if (numero == this.preguntas.indexOf(pr) && pr.getNivel() == ronda.getRonda() && pr.getCategoria().getCategoria() == ronda.getRonda()) {
                    boolean acierta = pr.preguntar(numero);
                    DB insertarPartida = new DB();
                    if (acierta) {
                        System.out.println("¡Correcto!");
                        asignarPuntaje(ronda, jugador);
                        ronda.setRonda(ronda.getRonda() + 1);
                        resultados(ronda, jugador);
                        if (ronda.getRonda() == 6) {
                            System.out.println("¡Haz ganado!");
                            insertarPartida.InsertOne(jugador.getNombre(), jugador.getPuntajeTotal());
                            ronda.setRonda(0);
                        } else {
                            boolean salir = salir();
                            if (salir) {
                                resultados(ronda, jugador);
                                insertarPartida.InsertOne(jugador.getNombre(), jugador.getPuntajeTotal());
                                this.salida = true;
                                ronda.setRonda(0);
                            }
                        }
                    } else {
                        System.out.println("¡Incorrecto!");
                        this.salida = true;
                        ronda.setRonda(0);
                        resultados(ronda, jugador);
                        insertarPartida.InsertOne(jugador.getNombre(), jugador.getPuntajeTotal());
                    }
                }
            }
        }
    }

    public void asignarPuntaje(Ronda ronda, Jugador jugador) {
        switch (ronda.getRonda()) {
            case 1:
                ronda.setPuntaje(ronda.getPuntaje() + 10);
                jugador.setPuntajeTotal(ronda.getPuntaje());
                break;
            case 2:
                ronda.setPuntaje(ronda.getPuntaje() + 20);
                jugador.setPuntajeTotal(ronda.getPuntaje());

                break;
            case 3:
                ronda.setPuntaje(ronda.getPuntaje() + 40);
                jugador.setPuntajeTotal(ronda.getPuntaje());

                break;
            case 4:
                ronda.setPuntaje(ronda.getPuntaje() + 80);
                jugador.setPuntajeTotal(ronda.getPuntaje());

                break;
            case 5:
                ronda.setPuntaje(ronda.getPuntaje() + 100);
                jugador.setPuntajeTotal(ronda.getPuntaje());
                break;
        }
    }

    public void resultados(Ronda ronda, Jugador jugador) {
        if (this.salida == true || ronda.getRonda() == 0) {
            ronda.setPuntaje(0);
            jugador.setPuntajeTotal(0);
            System.out.println("Tu puntaje total es: " + ronda.getPuntaje() + " :(");
            System.out.println("¡Más suerte para la próxima! \n");
        } else {
            System.out.println("Tu puntaje acumulado es: " + ronda.getPuntaje() + " :)");
        }
    }

    public boolean salir() {
        try {
            System.out.println("\n¿Deseas salir del concurso?");
            System.out.println("y/n?");
            Scanner sc = new Scanner(System.in);
            char respuestaSalida = sc.nextLine().charAt(0);
            if (respuestaSalida == 'y') {
                return true;
            } else {
                return false;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Debes elegir 'y' o 'n'...");
        }
        return salir();
    }
}
