import models.Course;
import models.OnlineCourse;
import models.OnSiteCourse;
import java.util.Scanner;
import services.PrinterService;

public class Main {

    public static void main(String[] args) {
        Course[] courses = registerCourses();
        printCourses(courses);
    }

    public static Course[] registerCourses() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de cursos:");
        int amount = Integer.parseInt(sc.nextLine());

        Course[] courseArray = new Course[amount];

        for (int i = 0; i < amount; i++) {
            System.out.println("\nCurso #" + (i + 1));
            courseArray[i] = readCourse(sc);
        }

        sc.close();
        return courseArray;
    }

    public static Course readCourse(Scanner sc) {
        String type = "";
        while (true) {
            System.out.println("Ingrese el tipo de curso (Online / OnSite):");
            type = sc.nextLine().trim();
            if (type.equalsIgnoreCase("Online") || type.equalsIgnoreCase("OnSite")) break;
            System.out.println("Modalidad invalida. Por favor vuelva a ingresar.");
        }

        System.out.println("Title:");
        String title = sc.nextLine();

        System.out.println("Duration (hours):");
        int duration = Integer.parseInt(sc.nextLine());

        System.out.println("Professor (optional):");
        String professor = sc.nextLine();

        if (type.equalsIgnoreCase("Online")) {
            System.out.println("Platform:");
            String platform = sc.nextLine();

            if (professor.isEmpty()) {
                return new OnlineCourse(title, duration, platform);
            } else {
                return new OnlineCourse(title, duration, professor, platform);
            }
        } else {
            System.out.println("Room:");
            String room = sc.nextLine();

            System.out.println("Quota:");
            int quota = Integer.parseInt(sc.nextLine());

            if (professor.isEmpty()) {
                return new OnSiteCourse(title, duration, room, quota);
            } else {
                return new OnSiteCourse(title, duration, professor, room, quota);
            }
        }
    }

    public static void printCourses(Course[] courses) {
        PrinterService printer = new PrinterService();
        printer.printCourseList(courses);
    }
}
