import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);

        courseService.addCourse(new Course("CS101", "Introduction to Programming", "Basics of Java", 40, "MWF 9-10"));
        courseService.addCourse(new Course("CS102", "Data Structures", "Intermediate level", 30, "TTH 10-11"));

        studentService.addStudent(new Student("S001", "Alice"));
        studentService.addStudent(new Student("S002", "Bob"));

        while (true) {
            System.out.println("Student Course Registration System");
            System.out.println("1. List Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Courses:");
                    courseService.listCourses();
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = studentService.getStudent(studentId);

                    if (student != null) {
                        System.out.print("Enter Course Code to Register: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseService.getCourse(courseCode);

                        if (course != null && course.hasAvailableSlot()) {
                            if (!student.getRegisteredCourses().contains(courseCode)) {
                                course.enrollStudent();
                                student.addCourse(courseCode);
                                System.out.println("Successfully registered for " + course.getTitle());
                            } else {
                                System.out.println("You are already registered for this course.");
                            }
                        } else {
                            System.out.println("Course is full or does not exist.");
                        }
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = studentService.getStudent(studentId);

                    if (student != null) {
                        System.out.print("Enter Course Code to Drop: ");
                        String courseCode = scanner.nextLine();
                        if (student.getRegisteredCourses().contains(courseCode)) {
                            student.removeCourse(courseCode);
                            courseService.getCourse(courseCode).dropStudent();
                            System.out.println("Successfully dropped the course.");
                        } else {
                            System.out.println("You are not registered for this course.");
                        }
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = studentService.getStudent(studentId);

                    if (student != null) {
                        System.out.println("Registered Courses for " + student.getName() + ":");
                        for (String registeredCourse : student.getRegisteredCourses()) {
                            Course course = courseService.getCourse(registeredCourse);
                            System.out.println("Code: " + course.getCourseCode() + ", Title: " + course.getTitle());
                        }
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
