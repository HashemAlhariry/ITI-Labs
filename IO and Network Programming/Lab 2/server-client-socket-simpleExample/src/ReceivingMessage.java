import java.io.*;
import java.net.Socket;

public class ReceivingMessage implements Runnable{

    private Socket incoming;
    public ReceivingMessage(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {

        try (InputStream inStream = incoming.getInputStream();) {
            System.out.println("FROM REC");
            String testString = "";
            while (!testString.equals("bye")) {
                DataInputStream socketDIS = new DataInputStream(inStream);
                testString = socketDIS.readUTF();
                System.out.println(testString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
