package concursopreguntas;

import concursopreguntas.entidades.Categoria;
import concursopreguntas.entidades.Jugador;
import concursopreguntas.entidades.Pregunta;
import concursopreguntas.entidades.Respuesta;
import concursopreguntas.entidades.Ronda;
import db.DB;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class concursoPreguntas {

    public static void main(String[] args) {
        DB conn = new DB();

        construirConcurso consConsurso = new construirConcurso();
        consConsurso.agregarPregunta(new Pregunta("¿Cuánto es 10 + 15?", Arrays.asList(
                new Respuesta("25", true),
                new Respuesta("5", false),
                new Respuesta("15", false),
                new Respuesta("35", false)
        ), new Categoria(1, "Matemáticas"), 1));
        consConsurso.agregarPregunta(new Pregunta("¿9 x 6 es?", Arrays.asList(
                new Respuesta("72", false),
                new Respuesta("36", false),
                new Respuesta("27", false),
                new Respuesta("54", true)
        ), new Categoria(2, "Matemáticas"), 2));
        consConsurso.agregarPregunta(new Pregunta("¿50 ÷ 10 es?", Arrays.asList(
                new Respuesta("10", false),
                new Respuesta("5", true),
                new Respuesta("20", false),
                new Respuesta("15", false)
        ), new Categoria(3, "Matemáticas"), 3));
        consConsurso.agregarPregunta(new Pregunta("¿Este símbolo % es?", Arrays.asList(
                new Respuesta("Suma", false),
                new Respuesta("Resta", false),
                new Respuesta("Porcentaje", true),
                new Respuesta("División", false)
        ), new Categoria(4, "Matemáticas"), 4));
        consConsurso.agregarPregunta(new Pregunta("¿299 - 100?", Arrays.asList(
                new Respuesta("100", false),
                new Respuesta("200", false),
                new Respuesta("99", false),
                new Respuesta("199", true)
        ), new Categoria(5, "Matemáticas"), 5));

        consConsurso.agregarPregunta(new Pregunta("¿Cuántas letras tiene la palabra ovni?", Arrays.asList(
                new Respuesta("5", false),
                new Respuesta("4", true),
                new Respuesta("7", false),
                new Respuesta("6", false)
        ), new Categoria(1, "Español"), 1));
        consConsurso.agregarPregunta(new Pregunta("¿Cuántas sílabas hay en la palabra 'Avión'?", Arrays.asList(
                new Respuesta("1", false),
                new Respuesta("3", false),
                new Respuesta("2", true),
                new Respuesta("Ninguna", false)
        ), new Categoria(2, "Español"), 2));
        consConsurso.agregarPregunta(new Pregunta("¿Cuál es correcta?", Arrays.asList(
                new Respuesta("Silába", false),
                new Respuesta("Sílaba", true),
                new Respuesta("Silabá", false),
                new Respuesta("Silbaba", false)
        ), new Categoria(3, "Español"), 3));
        consConsurso.agregarPregunta(new Pregunta("¿Qué nombre recibe este símbolo ¨?", Arrays.asList(
                new Respuesta("Dos puntos", false),
                new Respuesta("Comilla", false),
                new Respuesta("Diéresis", true),
                new Respuesta("Todas las anteriores", false)
        ), new Categoria(4, "Español"), 4));
        consConsurso.agregarPregunta(new Pregunta("¿Cómo se llama este símbolo ~?", Arrays.asList(
                new Respuesta("Apóstrofe", false),
                new Respuesta("Virgulilla", true),
                new Respuesta("Tilde", false),
                new Respuesta("Coma", false)
        ), new Categoria(5, "Español"), 5));

        consConsurso.agregarPregunta(new Pregunta("¿Cuántos litros de sangre tiene una persona adulta?", Arrays.asList(
                new Respuesta("Entre 4 y 6 litros", true),
                new Respuesta("Entre 2 y 4 litros", false),
                new Respuesta("7 litros", false),
                new Respuesta("10 litros", false)
        ), new Categoria(1, "Cultura General"), 1));
        consConsurso.agregarPregunta(new Pregunta("¿Cuál es el país más grande y el más pequeño del mundo?", Arrays.asList(
                new Respuesta("China y Nauru", false),
                new Respuesta("Rusia y Vaticano", true),
                new Respuesta("India y San Marino", false),
                new Respuesta("Estados Unidos y Malta", false)
        ), new Categoria(2, "Cultura General"), 2));
        consConsurso.agregarPregunta(new Pregunta("¿Cuántos jugadores por equipo participan en un partido de voleibol?", Arrays.asList(
                new Respuesta("2", false),
                new Respuesta("4", false),
                new Respuesta("6", true),
                new Respuesta("8", false)
        ), new Categoria(3, "Cultura General"), 3));
        consConsurso.agregarPregunta(new Pregunta("¿Cuántos decimales tiene el número pi π?", Arrays.asList(
                new Respuesta("100", false),
                new Respuesta("1000", false),
                new Respuesta("Infinitos", true),
                new Respuesta("10 Millones", false)
        ), new Categoria(4, "Cultura General"), 4));
        consConsurso.agregarPregunta(new Pregunta("¿Cuánto tiempo tarda la luz del Sol en llegar a la Tierra?", Arrays.asList(
                new Respuesta("1 día", false),
                new Respuesta("12 horas", false),
                new Respuesta("485 segundos", false),
                new Respuesta("8 minutos", true)
        ), new Categoria(5, "Cultura General"), 5));

        consConsurso.agregarPregunta(new Pregunta("¿Cuál es el planeta más pequeño de nuestro sistema solar?", Arrays.asList(
                new Respuesta("Venus", false),
                new Respuesta("Tierra", false),
                new Respuesta("Mercurio", true),
                new Respuesta("Marte", false)
        ), new Categoria(1, "Ciencia"), 1));
        consConsurso.agregarPregunta(new Pregunta("¿Cómo se llama el proceso por el cual las plantas elaboran su alimento?", Arrays.asList(
                new Respuesta("Nutrición", false),
                new Respuesta("Ingestión", false),
                new Respuesta("Fotosíntesis", true),
                new Respuesta("Relación", false)
        ), new Categoria(2, "Ciencia"), 2));
        consConsurso.agregarPregunta(new Pregunta("¿Qué utilizan los peces para respirar?", Arrays.asList(
                new Respuesta("Pulmones", false),
                new Respuesta("Branquias", true),
                new Respuesta("La boca", false),
                new Respuesta("Tórax", false)
        ), new Categoria(3, "Ciencia"), 3));
        consConsurso.agregarPregunta(new Pregunta("¿Cómo se denomina la parte del cuerpo donde se juntan dos o más huesos?", Arrays.asList(
                new Respuesta("Articulaciones", true),
                new Respuesta("Cartílagos", false),
                new Respuesta("Tendones", false),
                new Respuesta("Uniones", false)
        ), new Categoria(4, "Ciencia"), 4));
        consConsurso.agregarPregunta(new Pregunta("¿Fuente de energía no renovable?", Arrays.asList(
                new Respuesta("El carbón", false),
                new Respuesta("El gas natural", false),
                new Respuesta("El petróleo", false),
                new Respuesta("Todas las anteriores", true)
        ), new Categoria(5, "Ciencia"), 5));

        consConsurso.agregarPregunta(new Pregunta("how many bones the human body have?", Arrays.asList(
                new Respuesta("206", true),
                new Respuesta("420", false),
                new Respuesta("250", false),
                new Respuesta("310", false)
        ), new Categoria(1, "Inglés"), 1));
        consConsurso.agregarPregunta(new Pregunta("Who is the author of the phrase \"Pienso, luego existo\"?", Arrays.asList(
                new Respuesta("Platón", false),
                new Respuesta("Galileo Galilei", false),
                new Respuesta("Sócrates", false),
                new Respuesta("Descartes", true)
        ), new Categoria(2, "Inglés"), 2));
        consConsurso.agregarPregunta(new Pregunta("¿Qué hora es en inglés \"It is a quarter past six\"?", Arrays.asList(
                new Respuesta("6:45", false),
                new Respuesta("3:46", false),
                new Respuesta("6:15", true),
                new Respuesta("6:30", false)
        ), new Categoria(3, "Inglés"), 3));
        consConsurso.agregarPregunta(new Pregunta("Who was the first man on the Moon?", Arrays.asList(
                new Respuesta("Buzz Aldrin", false),
                new Respuesta("Neil Armstrong", true),
                new Respuesta("Michael Collins", false),
                new Respuesta("Yuri Gagarin", false)
        ), new Categoria(4, "Inglés"), 4));
        consConsurso.agregarPregunta(new Pregunta("What is the chromosome that determines male sex?", Arrays.asList(
                new Respuesta("X", false),
                new Respuesta("Y", true),
                new Respuesta("M", false),
                new Respuesta("Z", false)
        ), new Categoria(5, "Inglés"), 5));

        Ronda ronda = new Ronda(1);
        do {
            System.out.println("\n¡¡CONCURSO DE PREGUNTAS!! \n1. Jugar. \n2. Instrucciones. \n3. Historial de partidas. \n4. Salir.");
            System.out.println("Elige: ");
            Scanner sc = new Scanner(System.in);
            try {
                int op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1:
                        Jugador nuevoJugador = new Jugador();
                        do {
                            System.out.println("\n¿Cuál es tu nombre?");
                            System.out.println("Respuesta: ");
                            Scanner sca = new Scanner(System.in);
                            nuevoJugador.setNombre(sca.nextLine());
                        } while ("".equals(nuevoJugador.getNombre()));
                        while (ronda.getRonda() != 0) {
                            consConsurso.preguntar(ronda, nuevoJugador);
                        }
                        op = 0;
                        break;
                    case 2:
                        System.out.println("\nReglas: \n- Si respondes una pregunta mal, perderás automáticamente. \n- Podrás retirarte en el momento que quieras con el puntaje acumulado que lleves.");
                        op = 0;
                        break;

                    case 3:
                        System.out.println("\nConsultando...");
                        conn.Find();
                        op = 0;
                        break;
                    case 4:
                        ronda.setRonda(0);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes elegir una opción...");
            }
        } while (ronda.getRonda() != 0);
    }
}
