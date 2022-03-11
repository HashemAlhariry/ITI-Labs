package codesamples;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleSocketClient {


    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",1300);
            InputStream sIn = s.getInputStream();
            DataInputStream socketDIS = new DataInputStream(sIn);
            String testString  = new String (socketDIS.readUTF());
            System.out.println(testString);

            socketDIS.close();
            sIn.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
