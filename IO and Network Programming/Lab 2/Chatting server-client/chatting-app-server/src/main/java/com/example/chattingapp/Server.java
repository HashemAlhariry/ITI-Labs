package com.example.chattingapp;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public List<Socket> sockets=new ArrayList<>();

    public void sendMessageToClient(String messageToClient ,Socket socket){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(messageToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error sending message to client");
        }
    }

    public void acceptSocket(ServerSocket serverSocket,VBox box){
        new Thread(() -> {
                while (true) {
                    Socket socket = null;
                    try {
                        System.out.println(Thread.currentThread());
                        socket = serverSocket.accept();
                        sockets.add(socket);
                        receiveMessageFromClient(box,socket,sockets.size()-1);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error creating server");
                    }
                }
        }).start();
    }


    public void receiveMessageFromClient(VBox vBox,Socket socket, int index){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String messageFromClient = bufferedReader.readLine();
                        Controller.addLabel(messageFromClient,vBox);

                        for(int i=0;i<sockets.size();i++){
                                if(i!= index)
                            sendMessageToClient( messageFromClient , sockets.get(i));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error receiving message from client");
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
