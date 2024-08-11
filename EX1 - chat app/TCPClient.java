import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // localhost
        int port = 3001;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to chat server");

            // Get and send the username
            System.out.print("Enter your username: ");
            String username = stdIn.readLine();
            out.println(username);
            System.out.print(username + " (You): ");

            // Start a thread to read messages from the server
            new Thread(new Runnable() {
                public void run() {
                    String serverMessage;
                    try {
                        while ((serverMessage = in.readLine()) != null) {
                            // Clear the line and move the cursor to the beginning
                            System.out.print("\r" + serverMessage + " ".repeat(username.length()+8) + "\n" + username + " (You): ");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            // Read user input and send to the server
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.print(username + " (You): ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
