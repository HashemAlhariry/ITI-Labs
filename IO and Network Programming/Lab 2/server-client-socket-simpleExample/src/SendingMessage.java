import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendingMessage implements Runnable{

    private Socket incoming;

    public SendingMessage(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = incoming.getOutputStream();
            DataOutputStream socketDos = new DataOutputStream(outputStream);
            boolean done = false;
            while (!done){
                Scanner sc=new Scanner(System.in);
                String line = sc.nextLine();
                socketDos.writeUTF(line);
                if(line.trim().equals("bye")){
                    done=true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
