import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ThreadedEchoServer {

    public static List<Socket> socketList=new ArrayList<>();

    public static void main(String[] args) {
        int counter = 0;
        try {
            ServerSocket ss = new ServerSocket(1299);
            while(true){

                Socket incoming =ss.accept();
                socketList.add(incoming);

                Runnable r = new ThreadedEchoHandler(incoming,counter);
                Thread t = new Thread(r);
                t.start();
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
