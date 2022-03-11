package com.example.chatingappclient;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

public class Client {


    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Client(Socket socket) {

        try {

            this.bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.socket = socket;

        } catch (IOException e) {
            System.out.println("Error creating client.");
            e.printStackTrace();
            closeEveryThing(this.socket,bufferedReader,bufferedWriter);
        }

    }


    public  void sendMessageToServer(String messageToServer){

        try {
            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error sending message to client");
            closeEveryThing(socket,bufferedReader,bufferedWriter);
        }

    }

    public void receiveMessageFromServer(VBox vboc){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String messageFromServer = bufferedReader.readLine();
                        Controller.addLabel(messageFromServer,vboc);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error receiving message from client");
                        closeEveryThing(socket,bufferedReader,bufferedWriter);
                        break;
                    }

                }
            }
        }).start();
    }

    public void closeEveryThing(Socket socket,BufferedReader bufferedReader,BufferedWriter bufferedWriter){
        try {
            if(bufferedReader!=null)
                bufferedReader.close();
            if(bufferedWriter!=null)
                bufferedWriter.close();
            if(socket!=null)
                socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
