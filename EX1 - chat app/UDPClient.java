import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");

            Scanner scanner = new Scanner(System.in);
            String text;

            while (true) {
                System.out.print("Enter message: ");
                text = scanner.nextLine();
                byte[] buffer = text.getBytes(); // Reset buffer size to match the input message length
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9876);
                socket.send(packet);

                // Prepare a new buffer for the incoming response
                buffer = new byte[1024]; // Ensure buffer is large enough to handle the incoming message
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String response = new String(packet.getData(), 0, packet.getLength());
                System.out.println(response);

                if ("exit".equalsIgnoreCase(text)) {
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error in UDP client: " + e.getMessage());
        }
    }
}
