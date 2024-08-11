import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {
    private static final long serialVersionUID = 1L;
    private Map<String, String> students; // Simple storage for demonstration

    protected StudentServiceImpl() throws RemoteException {
        super();
        students = new HashMap<>();
    }

    @Override
    public void addStudent(String rollNum, String name, String mobileNum, int yearOfStudy) throws RemoteException {
        String studentInfo = "Name: " + name + ", Mobile Number: " + mobileNum + ", Year of Study: " + yearOfStudy;
        students.put(rollNum, studentInfo);
        System.out.println("Student added: Roll Number=" + rollNum + ", " + studentInfo);
    }

    @Override
    public String getAllStudents() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : students.entrySet()) {
            sb.append("Roll Number: ").append(entry.getKey())
              .append(", ").append(entry.getValue())
              .append("\n");
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
