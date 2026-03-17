import java.util.ArrayList;
import java.util.Scanner;

public class GestorMediateca {

    static ArrayList<ItemBiblioteca> catalogo = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void mostrarCatalogo() {
        for (ItemBiblioteca item : catalogo) {
            System.out.println(item);
        }
    }

    public static void anadirItem() {
        System.out.println("Tipo (1 Libro, 2 Revista, 3 DVD): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Autor: ");
                String autor = sc.nextLine();
                catalogo.add(new Libro(id, titulo, autor));
                break;

            case 2:
                System.out.print("Número edición: ");
                int num = sc.nextInt();
                sc.nextLine();
                catalogo.add(new Revista(id, titulo, num));
                break;

            case 3:
                System.out.print("Director: ");
                String director = sc.nextLine();
                catalogo.add(new DVD(id, titulo, director));
                break;

            default:
                System.out.println("Tipo no válido");
        }
    }

    public static ItemBiblioteca buscarPorId(String id) {
        for (ItemBiblioteca item : catalogo) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public static void modificarTitulo() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        ItemBiblioteca item = buscarPorId(id);

        if (item != null) {
            System.out.print("Nuevo título: ");
            String nuevo = sc.nextLine();
            item.setTitulo(nuevo);
            System.out.println("Título actualizado.");
        } else {
            System.out.println("Ítem no encontrado.");
        }
    }

    public static void prestarItem() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        ItemBiblioteca item = buscarPorId(id);

        if (item != null) {
            if (!item.isEstadoPrestado()) {
                item.prestar();
                System.out.println("Prestado correctamente.");
                System.out.println("Tienes " + item.getDiasMaximosPrestamo() + " días.");
            } else {
                System.out.println("Ya está prestado.");
            }
        } else {
            System.out.println("Ítem no encontrado.");
        }
    }

    public static void devolverItem() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        ItemBiblioteca item = buscarPorId(id);

        if (item != null) {
            if (item.isEstadoPrestado()) {
                item.devolver();

                System.out.print("¿Hace cuantos dias fue prestado? ");
                int dias = sc.nextInt();
                sc.nextLine();

                if (dias > 0) {
                    double multa = item.calcularMulta(dias);
                    System.out.println("Multa: " + multa + "€");
                } else {
                    System.out.println("Devuelto a tiempo.");
                }
            } else {
                System.out.println("El ítem no estaba prestado.");
            }
        } else {
            System.out.println("Ítem no encontrado.");
        }
    }
}