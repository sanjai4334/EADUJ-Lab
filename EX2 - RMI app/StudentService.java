import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentService extends Remote {
    void addStudent(String rollNum, String name, String mobileNum, int yearOfStudy) throws RemoteException;
    String getAllStudents() throws RemoteException;
    Student getStudent(String rollNum) throws RemoteException;
    void updateStudent(String rollNum, String name, String mobileNum, int yearOfStudy) throws RemoteException;
    void deleteStudent(String rollNum) throws RemoteException;

}
