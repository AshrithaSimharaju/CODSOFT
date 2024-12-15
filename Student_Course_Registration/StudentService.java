import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private Map<String, Student> studentMap;

    public StudentService() {
        studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
    }

    public Student getStudent(String studentId) {
        return studentMap.get(studentId);
    }

    public void listStudents() {
        for (Student student : studentMap.values()) {
            System.out.println("ID: " + student.getStudentId() + "\nName: " + student.getName());
        }
    }
}
