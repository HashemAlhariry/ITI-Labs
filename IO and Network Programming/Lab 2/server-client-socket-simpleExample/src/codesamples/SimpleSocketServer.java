package codesamples;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(1300);
            Socket s =ss.accept();
            OutputStream socketOutStream = s.getOutputStream();
            DataOutputStream socketDos = new DataOutputStream(socketOutStream);
            socketDos.writeUTF("HELLO FROM SERVER");

            socketDos.close();
            socketOutStream.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
