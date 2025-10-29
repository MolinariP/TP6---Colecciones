

package tp6ejercicio1;

import java.util.ArrayList;


public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    
    public void listarProductos() {
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    public void buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.mostrarInfo();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
    
    public void eliminarProducto(String id) {
        Producto encontrado = null;
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                encontrado = p;
            }
        }
        if (encontrado != null) {
            productos.remove(encontrado);
            System.out.println("Producto " + encontrado + "\neliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.setCantidad(nuevaCantidad);
                System.out.println("Stock actualizado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void filtrarPorCategoria(CategoriaProducto categoria) {
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
            }
        }
    }

    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantidad();
        }
        return total;
    }

    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) return null;
        Producto max = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > max.getCantidad()) {
                max = p;
            }
        }
        return max;
    }

    public void filtrarProductosPorPrecio(double min, double max) {
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
            }
        }
    }

    public void mostrarCategoriasDisponibles() {
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println(c.name() + ": " + c.getDescripcion());
        }
    }
}
