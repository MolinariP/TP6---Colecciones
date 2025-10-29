
package tp6ejercicio2;


public class Main {
    public static void main(String[] args) {
        // 1. Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // 2. Crear autores
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiano");
        Autor autor2 = new Autor("A002", "J.K. Rowling", "Británica");
        Autor autor3 = new Autor("A003", "Julio Cortázar", "Argentino");

        // 3. Agregar libros
        biblioteca.agregarLibro("L001", "Cien años de soledad", 1967, autor1);
        biblioteca.agregarLibro("L002", "Harry Potter y la piedra filosofal", 1997, autor2);
        biblioteca.agregarLibro("L003", "Rayuela", 1963, autor3);
        biblioteca.agregarLibro("L004", "Harry Potter y la cámara secreta", 1998, autor2);
        biblioteca.agregarLibro("L005", "El amor en los tiempos del cólera", 1985, autor1);

        // 4. Listar todos los libros
        biblioteca.listarLibros();

        // 5. Buscar libro por ISBN
        System.out.println("\nBuscando libro L002...");
        Libro encontrado = biblioteca.buscarLibroPorIsbn("L002");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        } else {
            System.out.println("Libro no encontrado.");
        }

        // 6. Filtrar libros por año
        biblioteca.filtrarLibrosPorAnio(1997);

        // 7. Eliminar un libro
        biblioteca.eliminarLibro("L004");

        // 8. Mostrar cantidad de libros
        System.out.println("\nTotal de libros: " + biblioteca.obtenerCantidadLibros());

        // 9. Mostrar autores disponibles
        biblioteca.mostrarAutoresDisponibles();
    }
}

