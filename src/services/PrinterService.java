package services;

import models.Course;

public class PrinterService {

    public void printCourseList(Course[] courses) {
        System.out.println("\n--- Informacion de cursos registrados ---");

        for (int i = 0; i < courses.length; i++) {
            Course course = courses[i];
            if (course != null) {
                System.out.println(course.showInformation());
            } else {
                System.out.println("Curso numero" + (i + 1) + " no registrado correctamente.");
            }
        }
    }
}
