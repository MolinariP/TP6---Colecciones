
package tp6ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return cursos; }

    // Sincroniza ambos lados
    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            if (c.getProfesor() != this) {
                c.setProfesor(this);
            }
        }
    }

    // Sincroniza ambos lados (rompe vínculo)
    public void eliminarCurso(Curso c) {
        if (cursos.remove(c)) {
            if (c.getProfesor() == this) {
                c.setProfesor(null);
            }
        }
    }

    public void listarCursos() {
        System.out.println("\nCursos dictados por " + nombre + ":");
        if (cursos.isEmpty()) {
            System.out.println("   (sin cursos asignados)");
        } else {
            for (Curso c : cursos) {
                System.out.println("   - " + c.getCodigo() + ": " + c.getNombre());
            }
        }
    }

    public void mostrarInfo() {
        System.out.println(String.format("Profesor: %s (%s) | Cursos: %d",
                nombre, especialidad, cursos.size()));
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}

