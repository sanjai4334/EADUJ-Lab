import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class TCPServer {
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat server started...");
        try (ServerSocket serverSocket = new ServerSocket(3001)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Ask for username
                username = in.readLine();
                System.out.println(username + " has joined the chat.");
                broadcastMessage("", (username + " has joined the chat."));
                synchronized (clientHandlers) {
                    clientHandlers.add(this);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username, message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientHandlers) {
                    clientHandlers.remove(this);
                }
                System.out.println(username + " has left the chat.");
                broadcastMessage("", (username + " has left the chat."));
            }
        }

        private void broadcastMessage(String username, String message) {
            synchronized (clientHandlers) {
                for (ClientHandler handler : clientHandlers) {
                    if (handler != this) {
                        handler.out.println((username=="" ? "" : username + ": ") + message);
                    }
                }
            }
        }
    }
}

