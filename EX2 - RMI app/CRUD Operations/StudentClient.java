import java.rmi.Naming;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) {
        try {
            StudentService studentService = (StudentService) Naming.lookup("rmi://localhost:1099/StudentService");

            Scanner scanner = new Scanner(System.in);
            String choice;
            do {
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Get Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextLine();
            
                switch (choice) {
                    case "1":
                        // Add Student
                        System.out.print("Enter roll number: ");
                        String rollNum = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter mobile number: ");
                        String mobileNum = scanner.nextLine();
                        System.out.print("Enter year of study: ");
                        String yearOfStudyStr = scanner.nextLine();

                        // Convert year of study to integer
                        int yearOfStudy = Integer.parseInt(yearOfStudyStr);

                        studentService.addStudent(rollNum, name, mobileNum, yearOfStudy);
                        System.out.println("Student added successfully!");
                        break;
                    case "2":
                        // View All Students
                        System.out.println("Students List:");
                        String students = studentService.getAllStudents();
                        System.out.println(students);
                        break;
                    case "3":
                        // Get Student
                        System.out.print("Enter roll number: ");
                        String getRollNum = scanner.nextLine();
                        Student student = studentService.getStudent(getRollNum);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case "4":
                        // Update Student
                        System.out.print("Enter roll number to update: ");
                        String updateRollNum = scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String updateName = scanner.nextLine();
                        System.out.print("Enter new mobile number: ");
                        String updateMobileNum = scanner.nextLine();
                        System.out.print("Enter new year of study: ");
                        int updateYearOfStudy = Integer.parseInt(scanner.nextLine());
                        studentService.updateStudent(updateRollNum, updateName, updateMobileNum, updateYearOfStudy);
                        System.out.println("Student updated successfully!");
                        break;
                    case "5":
                        // Delete Student
                        System.out.print("Enter roll number to delete: ");
                        String deleteRollNum = scanner.nextLine();
                        studentService.deleteStudent(deleteRollNum);
                        System.out.println("Student deleted successfully!");
                        break;
                    case "6":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (!choice.equals("6"));

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
