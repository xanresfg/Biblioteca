public abstract class ItemBiblioteca {
    private String id;
    private String titulo;
    private boolean estadoPrestado;

    public ItemBiblioteca(String id, String titulo, boolean estadoPrestado) {
        this.id = id;
        this.titulo = titulo;
        this.estadoPrestado = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEstadoPrestado() {
        return estadoPrestado;
    }

    public void setEstadoPrestado(boolean estadoPrestado) {
        this.estadoPrestado = estadoPrestado;
    }

    public void prestar(){
        setEstadoPrestado(true);
    }

    public void devolver(){
        setEstadoPrestado(true);
    }

    public abstract int getDiasMaximosPrestamo();

    public abstract double calcularMulta(int diasRetraso);

    @Override
    public String toString() {
        return "ItemBiblioteca{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", estadoPrestado=" + estadoPrestado +
                '}';
    }
}
