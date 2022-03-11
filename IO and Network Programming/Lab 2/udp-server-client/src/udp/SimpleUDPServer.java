package udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimpleUDPServer {

    public static void main(String[] args) {
        DatagramSocket dgSocket = null;
        try{
            int socketNumebr = 1400;
            dgSocket = new DatagramSocket(socketNumebr);
            byte[] byteBuffer = new byte[1000];
            DatagramPacket datagramPacket = new DatagramPacket(byteBuffer,byteBuffer.length);
            dgSocket.receive(datagramPacket);
            System.out.println("HELLO AFTER RECEIVER");
            BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/hashemalhariry/Desktop/udp-server-client/src/udp/Demo.txt")));
            String line;
            while( (line = reader.readLine()) != null )
            {
                DatagramPacket dgresponse = new DatagramPacket(line.getBytes(), line.length(), datagramPacket.getAddress(), datagramPacket.getPort());
                dgSocket.send(dgresponse);
                Thread.sleep(200);
            }
            String end = "nothing";
            DatagramPacket data = new DatagramPacket(end.getBytes(), end.length(), datagramPacket.getAddress(), datagramPacket.getPort());
            dgSocket.send(data);
        }catch (SocketException | InterruptedException e) {
            System.out.println("Socket Exception : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception : " + e.getMessage());
        }finally {
            if (dgSocket != null)
              dgSocket.close();
        }

    }
}
