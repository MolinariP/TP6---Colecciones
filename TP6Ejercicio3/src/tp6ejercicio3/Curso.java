
package tp6ejercicio3;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor; // relación bidireccional

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    // Sincroniza ambos lados
    public void setProfesor(Profesor nuevoProfesor) {
        // Si ya tenía un profesor asignado, quitarlo de su lista
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.getCursos().remove(this);
        }

        this.profesor = nuevoProfesor;

        // Si el nuevo profesor no lo tiene en su lista, agregarlo
        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String prof = (profesor != null) ? profesor.getNombre() : "Sin asignar";
        return String.format("Curso: %s (%s) | Profesor: %s", nombre, codigo, prof);
    }
}

