import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization versioning
    private String courseName;
    private List<String> enrolledStudents;
    private List<String> assignments;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(String student) {
        enrolledStudents.add(student);
    }

    public void addAssignment(String assignment) {
        assignments.add(assignment);
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }
}
