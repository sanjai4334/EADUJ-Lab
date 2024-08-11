import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876)) {
            System.out.println("Server is listening on port 9876");

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                String response = "Server: " + received;
                byte[] responseBuffer = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length, address, port);
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            System.out.println("Error in UDP server: " + e.getMessage());
        }
    }
}
