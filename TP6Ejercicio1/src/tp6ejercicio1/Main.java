

package tp6ejercicio1;


public class Main {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        
        Producto p1 = new Producto("A-10001", "Fideos", 2500, 15, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E-20003", "TV 50 pulgadas", 550000, 5, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R-31505", "Campera", 150000, 10, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H-40301", "Batidora", 35000, 7, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A-10402", "Yerba", 1900, 40, CategoriaProducto.ALIMENTOS);
    
        // Agregar productos
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);

        System.out.println("LISTA DE PRODUCTOS:");
        inventario.listarProductos();

        System.out.println("\nBUSCAR PRODUCTO POR ID:");
        inventario.buscarProductoPorId("E-20003");

        System.out.println("\nPRODUCTOS DE CATEGORIA ALIMENTOS");
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);

        System.out.println("\nELIMINAR PRODUCTO ID: ");
        inventario.eliminarProducto("R-31505");
        System.out.println("LISTA DE PRODUCTOS:");
        inventario.listarProductos();

        System.out.println("\nACTUALIZAR STOCK DEL PRODUCTO: ");
        inventario.actualizarStock("A-10402", 50);
        inventario.buscarProductoPorId("A-10402");

        System.out.println("\nTOTAL DE STOCK DISPONIBLE: ");
        System.out.println("Total de unidades: " + inventario.obtenerTotalStock());

        System.out.println("\nPRODUCTO CON MAYOR STOCK: ");
        Producto mayor = inventario.obtenerProductoConMayorStock();
        if (mayor != null) mayor.mostrarInfo();

        System.out.println("\nPRODUCTOS CON PRECIO ENTRE $1000 Y $3000: ");
        inventario.filtrarProductosPorPrecio(1000, 3000);

        System.out.println("\nCATEGORIAS DISPONIBLES: ");
        inventario.mostrarCategoriasDisponibles();
    }
}
