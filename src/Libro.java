public class Libro extends ItemBiblioteca{
    private String autor;

    public Libro(String id, String titulo, String autor) {
        super(id, titulo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int getDiasMaximosPrestamo(){
        return 14;
    }

    @Override
    public double calcularMulta(int diasRetraso){
        return (diasRetraso-getDiasMaximosPrestamo())*0.5;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", autor='" + autor + '\'';
    }
}
