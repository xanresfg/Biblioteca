public class DVD extends ItemBiblioteca{
    private String director;

    public DVD(String id, String titulo, boolean estadoPrestado, String director) {
        super(id, titulo, estadoPrestado);
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
}
