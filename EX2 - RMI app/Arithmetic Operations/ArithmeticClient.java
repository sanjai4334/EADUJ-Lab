import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ArithmeticClient {
    public static void main(String[] args) {
        try {
            ArithmeticService arithmeticService = (ArithmeticService) Naming.lookup("rmi://localhost:1099/ArithmeticService");

            Scanner scanner = new Scanner(System.in);
            String choice;
            do {
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextLine();

                if (!choice.equals("5")) {
                    System.out.print("Enter first number: ");
                    double a = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter second number: ");
                    double b = Double.parseDouble(scanner.nextLine());

                    switch (choice) {
                        case "1":
                            System.out.println("Result: " + arithmeticService.add(a, b));
                            break;
                        case "2":
                            System.out.println("Result: " + arithmeticService.subtract(a, b));
                            break;
                        case "3":
                            System.out.println("Result: " + arithmeticService.multiply(a, b));
                            break;
                        case "4":
                            try {
                                System.out.println("Result: " + arithmeticService.divide(a, b));
                            } catch (RemoteException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            } while (!choice.equals("5"));

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
