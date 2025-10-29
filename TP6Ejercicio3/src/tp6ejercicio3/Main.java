
package tp6ejercicio3;

public class Main {
    public static void main(String[] args) {

        Universidad uni = new Universidad("Universidad Nacional");

        // 1. Crear profesores
        Profesor p1 = new Profesor("P001", "Ana Torres", "Matemática");
        Profesor p2 = new Profesor("P002", "Carlos López", "Programación");
        Profesor p3 = new Profesor("P003", "Lucía Gómez", "Historia");

        // 2. Crear cursos
        Curso c1 = new Curso("C101", "Álgebra");
        Curso c2 = new Curso("C102", "Estructuras de Datos");
        Curso c3 = new Curso("C103", "Historia Moderna");
        Curso c4 = new Curso("C104", "Bases de Datos");
        Curso c5 = new Curso("C105", "Filosofía");

        // 3. Agregar a la universidad
        uni.agregarProfesor(p1);
        uni.agregarProfesor(p2);
        uni.agregarProfesor(p3);
        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);
        uni.agregarCurso(c4);
        uni.agregarCurso(c5);

        // 4. Asignar profesores
        uni.asignarProfesorACurso("C101", "P001");
        uni.asignarProfesorACurso("C102", "P002");
        uni.asignarProfesorACurso("C103", "P003");
        uni.asignarProfesorACurso("C104", "P002");

        // 5. Listar
        uni.listarProfesores();
        uni.listarCursos();

        // 6. Cambiar profesor de un curso
        System.out.println("\nReasignando profesor del curso C104...");
        uni.asignarProfesorACurso("C104", "P001");

        // 7. Eliminar curso
        uni.eliminarCurso("C103");

        // 8. Eliminar profesor
        uni.eliminarProfesor("P002");

        // 9. Reporte
        uni.mostrarReporteCursosPorProfesor();
    }
}
