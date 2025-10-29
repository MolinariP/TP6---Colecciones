
package tp6ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
        System.out.println("Libro agregado: " + titulo);
    }

    public void listarLibros() {
        System.out.println("\nLibros en la biblioteca '" + nombre + "':");
        for (Libro l : libros) {
            l.mostrarInfo();
        }
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        return null;
    }

    public void eliminarLibro(String isbn) {
        Libro libroAEliminar = null;

        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                libroAEliminar = l;
            }
        }

        if (libroAEliminar != null) {
            libros.remove(libroAEliminar);
            System.out.println("ELIMINAR LIBRO ISBN: " + libroAEliminar.getIsbn());
            System.out.println("Libro " + libroAEliminar.getTitulo() + " eliminado correctamente.");
        } else {
            System.out.println("No se encontró el libro con ISBN: " + isbn);
        }
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public void filtrarLibrosPorAnio(int anio) {
        System.out.println("\nLibros publicados en " + anio + ":");
        for (Libro l : libros) {
            if (l.getAnioPublicacion() == anio) {
                l.mostrarInfo();
            }
        }
    }

    public void mostrarAutoresDisponibles() {
        System.out.println("\nAutores disponibles en la biblioteca:");
        List<String> autoresMostrados = new ArrayList<>();

        for (Libro l : libros) {
            String nombreAutor = l.getAutor().getNombre();
            if (!autoresMostrados.contains(nombreAutor)) {
                System.out.println("- " + l.getAutor());
                autoresMostrados.add(nombreAutor);
            }
        }
    }
}

