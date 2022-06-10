package concursopreguntas.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Pregunta {

    private String enunciado;
    private List<Respuesta> respuestas;
    private Categoria categoria;
    private int nivel;

    private static final String letras = "1234";

    public Pregunta(String enunciado, List<Respuesta> respuestas, Categoria categoria, int nivel) {
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.categoria = categoria;
        this.nivel = nivel;
    }

    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
        this.respuestas = new ArrayList();
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean respuestaCorrecta(char respuesta) {
        int index = letras.indexOf(respuesta);
        if (index == -1) {
            return false;
        }
        return this.respuestas.get(index).isCorrecta();
    }

    public boolean preguntar(int numero) {
        char respuesta = 0;
        try {
            System.out.println("\nCategoría: " + this.categoria.getDescripcion() + "\nNivel: " + this.getNivel());
            System.out.println(this.categoria.getCategoria() + ". " + this.enunciado);
            int index = 0;
            for (Respuesta rs : this.respuestas) {
                System.out.printf("%c) %s\n", letras.charAt(index), rs.getRespuesta());
                index++;
            }
            System.out.println("Elige: ");
            Scanner sc = new Scanner(System.in);
            respuesta = sc.nextLine().charAt(0);
            return this.respuestaCorrecta(respuesta);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Debes elegir una opción de respuesta...");
        }
        return preguntar(numero);
    }
}
