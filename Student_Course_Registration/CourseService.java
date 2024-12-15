import java.util.HashMap;
import java.util.Map;

public class CourseService {
    private Map<String, Course> courseMap;

    public CourseService() {
        courseMap = new HashMap<>();
    }

    public void addCourse(Course course) {
        courseMap.put(course.getCourseCode(), course);
    }

    public void listCourses() {
        for (Course course : courseMap.values()) {
            System.out.println("Code: " + course.getCourseCode() + "\nTitle: " + course.getTitle() +
                    "\nDescription: " + course.getDescription() +
                    "\nSlots: " + (course.getCapacity() - course.getEnrolledStudents()) +
                    "\nSchedule: " + course.getSchedule());
        }
    }

    public Course getCourse(String courseCode) {
        return courseMap.get(courseCode);
    }
}
