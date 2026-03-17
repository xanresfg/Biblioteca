public class Libro extends ItemBiblioteca{
    private String autor;

    public Libro(String id, String titulo, boolean estadoPrestado, String autor) {
        super(id, titulo, estadoPrestado);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
