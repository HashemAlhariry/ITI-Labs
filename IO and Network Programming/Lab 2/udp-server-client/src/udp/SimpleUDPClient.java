package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SimpleUDPClient {

    public static void main(String[] args) {
        DatagramSocket dgSocket = null;
        try {
            dgSocket = new DatagramSocket();
            byte[] bytebuffer = new byte[1000];
            int serverPortNumber=1400;
            InetAddress serverHost = InetAddress.getLocalHost();
            DatagramPacket request = new DatagramPacket(bytebuffer,bytebuffer.length,serverHost,serverPortNumber);
            dgSocket.send(request);
            String lines="";
            while(!lines.contains("nothing")){
                byte[] receivingBuffer = new byte[1000];
                DatagramPacket data = new DatagramPacket(receivingBuffer,receivingBuffer.length);
                dgSocket.receive(data);
                lines = new String(data.getData(),data.getOffset(),data.getLength());
                if(!lines.contains("nothing"))
                      System.out.println(lines);
            }
        }catch (SocketException e) {
            System.out.println("Socket Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception : " + e.getMessage());
        } finally {
            if (dgSocket != null)
                dgSocket.close();
        }
    }
}
