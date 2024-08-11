import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {
    private static final long serialVersionUID = 1L;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:9999/studentdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";

    protected StudentServiceImpl() throws RemoteException {
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(String rollNum, String name, String mobileNum, int yearOfStudy) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO students (rollNum, name, mobileNum, yearOfStudy) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, rollNum);
            stmt.setString(2, name);
            stmt.setString(3, mobileNum);
            stmt.setInt(4, yearOfStudy);
            stmt.executeUpdate();
            System.out.println("Student added: Roll Number=" + rollNum + ", Name=" + name + ", Mobile Number=" + mobileNum + ", Year of Study=" + yearOfStudy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAllStudents() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String studentInfo = "Roll Number: " + rs.getString("rollNum") + ", Name: " + rs.getString("name") +
                        ", Mobile Number: " + rs.getString("mobileNum") + ", Year of Study: " + rs.getInt("yearOfStudy");
                sb.append(studentInfo).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the implementation class
            StudentServiceImpl obj = new StudentServiceImpl();

            // Bind the remote object (StudentServiceImpl) to the RMI registry
            Naming.rebind("rmi://localhost:1099/StudentService", obj);

            System.out.println("StudentService bound in registry");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
