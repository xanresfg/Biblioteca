public class DVD extends ItemBiblioteca{
    private String director;

    public DVD(String id, String titulo, String director) {
        super(id, titulo);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getDiasMaximosPrestamo(){
        return 3;
    }

    @Override
    public double calcularMulta(int diasRetraso){
        return (diasRetraso-getDiasMaximosPrestamo())*2;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", director='" + director + '\'';
    }
}
