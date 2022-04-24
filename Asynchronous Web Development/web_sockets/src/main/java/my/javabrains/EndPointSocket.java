package my.javabrains;



import com.google.gson.Gson;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/endpoint")
public class EndPointSocket {


    private final static Set<Session> sessions = new HashSet<>();
    private final static ArrayList<User> users = new ArrayList<>();
    private final static ArrayList<Message> messages = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){

        sessions.add(session);
        //split query string make user
        users.add(getUser(session.getQueryString()));
        Gson gson = new Gson();
        String usersObj = gson.toJson(users);

      for(Session currSession: sessions){
          try {
              currSession.getBasicRemote().sendText(usersObj);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

      if(messages.size()>0){
          String messagesArray = gson.toJson(messages);
          try {
                  session.getBasicRemote().sendText(messagesArray);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }

    public User getUser(String user){
        String [] queryString=user.split("&");
        String name = queryString[0].substring(5);
        String gender = queryString[1].substring(7);
        return new User(name,gender);
    }


    @OnMessage
    public void onMessage(String message , Session session){

        String [] queryString = session.getQueryString().split("&");
        String name = queryString[0].substring(5);
        String gender = queryString[1].substring(7);

        Message currentMessage = new Message(message, new User(name,gender) , LocalTime.now().toString());
        messages.add(currentMessage);
        Gson gson = new Gson();
        String currentMessageObject = gson.toJson(currentMessage);

        for(Session sess : sessions){
            try {
                sess.getBasicRemote().sendText(currentMessageObject);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @OnClose
    public  void onClose(Session session){

        String [] queryString=session.getQueryString().split("&");
        String name = queryString[0].substring(5);

        for (User user:users) {
            if(user.name.equals(name)){
                users.remove(user);
                break;
            }
        }

        sessions.remove(session);

        Gson gson = new Gson();
        String usersObj = gson.toJson(users);

        for(Session currSession: sessions){
            try {
                currSession.getBasicRemote().sendText(usersObj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
