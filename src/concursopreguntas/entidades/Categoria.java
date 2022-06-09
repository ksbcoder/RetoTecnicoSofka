package concursopreguntas.entidades;

/**
 *
 * @author kevin
 */
public class Categoria {

    private int categoria;
    private String descripcion;

    public Categoria(int categoria, String descripcion) {
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
