import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ArithmeticServiceImpl extends UnicastRemoteObject implements ArithmeticService {
    private static final long serialVersionUID = 1L;

    protected ArithmeticServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division by zero is not allowed");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            ArithmeticServiceImpl obj = new ArithmeticServiceImpl();
            Naming.rebind("rmi://localhost:1099/ArithmeticService", obj);
            System.out.println("ArithmeticService bound in registry");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
