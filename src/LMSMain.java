import java.util.Scanner;

public class LMSMain {

    public static void main(String[] args) {
        LMS lms = new LMS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLMS Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Add Assignment to Course");
            System.out.println("5. Print Course Details");
            System.out.println("6. Save Data to File");
            System.out.println("7. Load Data from File");
            System.out.println("8. Cancel Enrollment");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1: // Add User
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    System.out.print("Is the user an instructor? (true/false): ");
                    boolean isInstructor = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline left-over

                    lms.addUser(username, password, isInstructor);
                    System.out.println("User added successfully.");
                    break;

                case 2: // Add Course
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();

                    lms.addCourse(courseName);
                    System.out.println("Course added successfully.");
                    break;

                case 3: // Enroll Student
                    System.out.print("Enter student username: ");
                    String studentUsername = scanner.nextLine();

                    System.out.print("Enter course name: ");
                    String courseForEnrollment = scanner.nextLine();

                    lms.enrollStudent(studentUsername, courseForEnrollment);
                    break;

                case 4: // Add Assignment to Course
                    System.out.print("Enter course name: ");
                    String courseForAssignment = scanner.nextLine();

                    System.out.print("Enter assignment description: ");
                    String assignmentDescription = scanner.nextLine();

                    lms.addAssignmentToCourse(courseForAssignment, assignmentDescription);
                    System.out.println("Assignment added successfully.");
                    break;

                case 5: // Print Course Details
                    System.out.print("Enter course name: ");
                    String courseForDetails = scanner.nextLine();

                    lms.printCourseDetails(courseForDetails);
                    break;

                case 6: // Save Data to File
                    System.out.print("Enter filename to save data: ");
                    String saveFilename = scanner.nextLine();
                    lms.saveToFile(saveFilename);
                    break;

                case 7: // Load Data from File
                    System.out.print("Enter filename to load data: ");
                    String loadFilename = scanner.nextLine();
                    lms.loadFromFile(loadFilename);
                    break;

                case 8: // Cancel Enrollment
                    System.out.print("Enter student username: ");
                    String cancelUsername = scanner.nextLine();

                    System.out.print("Enter course name: ");
                    String cancelCourseName = scanner.nextLine();

                    lms.cancelEnrollment(cancelUsername, cancelCourseName);
                    break;

                case 9: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
