
package tp6ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarProfesor(Profesor p) {
        profesores.add(p);
        System.out.println("Profesor agregado: " + p.getNombre());
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
        System.out.println("Curso agregado: " + c.getNombre());
    }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    // Usa la sincronización interna de Curso.setProfesor()
    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso != null && profesor != null) {
            curso.setProfesor(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " asignado a curso " + curso.getNombre());
        } else {
            System.out.println("No se pudo asignar (curso o profesor inexistente).");
        }
    }

    public void listarProfesores() {
        System.out.println("\nProfesores en la universidad:");
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
    }

    public void listarCursos() {
        System.out.println("\nCursos disponibles:");
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }

    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            if (curso.getProfesor() != null) {
                curso.getProfesor().eliminarCurso(curso);
            }
            cursos.remove(curso);
            System.out.println("Curso " + curso.getNombre() + " eliminado.");
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    public void eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Romper vínculos con sus cursos
            for (Curso c : new ArrayList<>(profesor.getCursos())) {
                c.setProfesor(null);
            }
            profesores.remove(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " eliminado.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    // 📊 Reporte final
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\nCantidad de cursos por profesor:");
        for (Profesor p : profesores) {
            System.out.println("- " + p.getNombre() + ": " + p.getCursos().size() + " curso(s)");
        }
    }
}

