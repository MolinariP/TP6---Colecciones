
package tp6ejercicio1;


public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    
    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }

    // Setters
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    // mostrarInfo
    public void mostrarInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %s | Precio: $%.2f | Stock: %d | Categoría: %s (%s)",
                id, nombre, precio, cantidad, categoria.name(), categoria.getDescripcion());
    }
}
