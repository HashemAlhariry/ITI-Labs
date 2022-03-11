import java.io.*;
import java.net.Socket;


public class ThreadedEchoHandler implements Runnable {


    private Socket incoming;
    private int myNumber;
    public ThreadedEchoHandler(Socket incoming,int myNumber) {
        this.incoming = incoming;
        this.myNumber=myNumber;
    }

    @Override
    public void run() {

        try (InputStream inStream = incoming.getInputStream();) {


            String testString = "";
            System.out.println("Current Thread"+Thread.currentThread());

            while (!testString.trim().equals("bye")) {
            DataInputStream socketDIS = new DataInputStream(inStream);
            testString = socketDIS.readUTF();
            System.out.println(testString);


                for (int i = 0; i < ThreadedEchoServer.socketList.size() ; i++) {
                    if(myNumber!=i){
                    OutputStream outputStream = ThreadedEchoServer.socketList.get(i).getOutputStream();
                    DataOutputStream socketDos = new DataOutputStream(outputStream);
                    socketDos.writeUTF(testString);}
                }

           }
           incoming.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
