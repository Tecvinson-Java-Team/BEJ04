

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LMS {
    private Map<String, User> users;
    private Map<String, Course> courses;

    public LMS() {
        users = new HashMap<>();
        courses = new HashMap<>();
    }

    public void addUser(String username, String password, boolean isInstructor) {
        users.put(username, new User(username, password, isInstructor));
    }

    public void addCourse(String courseName) {
        courses.put(courseName, new Course(courseName));
    }

    public void enrollStudent(String username, String courseName) {
        User user = users.get(username);
        Course course = courses.get(courseName);

        if (user == null) {
            System.out.println("Enrollment failed: User not found.");
            return;
        }

        if (course == null) {
            System.out.println("Enrollment failed: Course not found.");
            return;
        }

        if (user.isInstructor()) {
            System.out.println("Enrollment failed: Instructor cannot be enrolled in a course.");
            return;
        }

        course.addStudent(username);
        System.out.println("Student enrolled successfully.");
    }

    public void cancelEnrollment(String username, String courseName) {
        Course course = courses.get(courseName);

        if (course == null) {
            System.out.println("Cancellation failed: Course not found.");
            return;
        }

        if (!course.getEnrolledStudents().contains(username)) {
            System.out.println("Cancellation failed: Student not enrolled in this course.");
            return;
        }

        course.getEnrolledStudents().remove(username);
        System.out.println("Enrollment cancelled successfully.");
    }

    public void addAssignmentToCourse(String courseName, String assignment) {
        Course course = courses.get(courseName);

        if (course != null) {
            course.addAssignment(assignment);
            System.out.println("Assignment added successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void printCourseDetails(String courseName) {
        Course course = courses.get(courseName);
        if (course != null) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Assignments: " + course.getAssignments());
            System.out.println("Enrolled Students: " + course.getEnrolledStudents());
        } else {
            System.out.println("Course not found.");
        }
    }

    // Save the state to a file
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(users);
            oos.writeObject(courses);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving data.");
        }
    }

    // Load the state from a file
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            users = (Map<String, User>) ois.readObject();
            courses = (Map<String, Course>) ois.readObject();
            System.out.println("Data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading data.");
        }
    }
}
