import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private List<String> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void addCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void removeCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}
