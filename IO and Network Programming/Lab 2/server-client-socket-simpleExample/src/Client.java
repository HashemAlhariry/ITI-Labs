import java.io.IOException;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost",1299);

            SendingMessage sendingMessage = new SendingMessage(socket);
            ReceivingMessage receivingMessage = new ReceivingMessage(socket);

            Thread thread1 = new Thread(sendingMessage);
            Thread thread2 = new Thread(receivingMessage);

            thread1.start();
            thread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
