import java.util.Scanner;
import models.Course;
import models.OnlineCourse;
import models.OnSiteCourse;
import services.PrinterService;


public class Main {
    public static void main(String[] args) {
        //Abro scanner
        Scanner sc = new Scanner(System.in);

        //Dato cantidad de cursos
        System.out.println("Ingresar el numero de cursos a registrar:");
        int amount = Integer.parseInt(sc.nextLine());
        Course[] courseArray = new Course[amount];

        //Controlo cantidad de cursos
        int index = 0;

        //igual o menor a 0 salgo
        while (index < amount) {
            System.out.println("\nCurso #" + (index + 1));

            String courseType = "";
            boolean valid = false;
        
            //Tipo de curso
            while (!valid) {
                System.out.println("Ingrese el tipo de curso (Online or OnSite):");
                courseType = sc.nextLine();
                if (courseType.equalsIgnoreCase("Online") || courseType.equalsIgnoreCase("OnSite")) {
                    valid = true;
                } else {
                    System.out.println("Tipo invalido, por favor vuelva a ingresar.");
                }
            }
            //Datos del curso
            System.out.println("Title:");
            String title = sc.nextLine();

            System.out.println("Duration (hours):");
            int duration = Integer.parseInt(sc.nextLine());

            System.out.println("Professor (optional):");
            String professor = sc.nextLine();
            
            //Control de campos vacios
            if (courseType.equalsIgnoreCase("Online")) {
                System.out.println("Platform:");
                String platform = sc.nextLine();

                if (professor.isEmpty()) {
                    courseArray[index] = new OnlineCourse(title, duration, platform);
                } else {
                    courseArray[index] = new OnlineCourse(title, duration, professor, platform);
                }

            } else if (courseType.equalsIgnoreCase("OnSite")) {
                System.out.println("Room:");
                String room = sc.nextLine();

                System.out.println("Quota:");
                int quota = Integer.parseInt(sc.nextLine());

                if (professor.isEmpty()) {
                    courseArray[index] = new OnSiteCourse(title, duration, room, quota);
                } else {
                    courseArray[index] = new OnSiteCourse(title, duration, professor, room, quota);
                }
            }

            index++;
        }
        
        //Imprimo cursos
        PrinterService printer = new PrinterService();
        printer.printCourseList(courseArray);

        sc.close();
    }
}        