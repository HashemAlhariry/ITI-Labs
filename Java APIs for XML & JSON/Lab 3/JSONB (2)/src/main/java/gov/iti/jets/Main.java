package gov.iti.jets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.iti.jets.lab.*;
import gov.iti.jets.tree.JsonWriterDemo;
import gov.iti.jets.tree.JsonReaderDemo;
import jakarta.json.*;
import jakarta.json.bind.JsonbBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws Exception {


          List<UserInfo> userInfos = new ArrayList<>();
          Main main = new Main();

          List<Post> posts =  main.getPosts();
          List<Comment> comments =  main.getComments();
          List<User> users= main.getUsers();


          //to be inserted in json
          List<UserInfo> userInformations = new ArrayList<>();

          for (int i = 0; i <users.size() ; i++) {
                User user = users.get(i);
                List<PostInfo> postsForUser = new ArrayList<>();
                for (int j = 0; j <posts.size(); j++) {
                    if(user.id==posts.get(j).userId){
                        Post post = posts.get(j);
                        List<String> commentsForPost = new ArrayList<>();
                        for (int k = 0; k < comments.size(); k++) {
                            if (post.getId() == comments.get(k).postId) {
                                commentsForPost.add(comments.get(k).email);
                            }
                        }
                        PostInfo postInfo = new PostInfo(post.title, commentsForPost);
                        postsForUser.add(postInfo);
                     }
                }
                UserInfo userInfo = new UserInfo(user.name, user.userName,user.phone, user.email, postsForUser);
                userInformations.add(userInfo);
            }
          System.out.println(userInformations.size());
          main.produceJson(userInformations);

    }

    public List<Post> getPosts() throws Exception {
        List<Post> postList= new ArrayList<>();
        File file = new File(getClass().getResource("/binding/posts.json").toURI());
        JsonReader reader = Json.createReader(new FileReader(file));
        JsonArray jsonArray = reader.readArray();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JsonString titleJsonString = jsonArray.getJsonObject(i).getJsonString("title") ;
            JsonString bodyJsonString = jsonArray.getJsonObject(i).getJsonString("body") ;
            JsonNumber idJsonString = jsonArray.getJsonObject(i).getJsonNumber("id") ;
            JsonNumber userIdJsonString = jsonArray.getJsonObject(i).getJsonNumber("userId") ;
            Post post = new Post(userIdJsonString.intValue(), idJsonString.intValue(),titleJsonString.toString(), bodyJsonString.toString()) ;
            postList.add(post);
        }
        return  postList;
    }
    public List<Comment> getComments() throws Exception{
        File file = new File(getClass().getResource("/binding/comments.json").toURI());
        JsonReader reader = Json.createReader(new FileReader(file));
        JsonArray jsonArray = reader.readArray();
        List<Comment> comments = new ArrayList<>();
        //(int postId, int id, String name, String email, String body)
        for (int i = 0; i <jsonArray.size() ; i++){
            JsonNumber id = jsonArray.getJsonObject(i).getJsonNumber("id") ;
            JsonNumber postId = jsonArray.getJsonObject(i).getJsonNumber("postId") ;
            JsonString name = jsonArray.getJsonObject(i).getJsonString("name") ;
            JsonString email = jsonArray.getJsonObject(i).getJsonString("email") ;
            JsonString body = jsonArray.getJsonObject(i).getJsonString("body") ;
            Comment comment = new Comment(postId.intValue(),id.intValue(),name.toString(),email.toString(),body.toString());
            comments.add(comment);
        }
        return comments;
    }
    public List<User> getUsers() throws Exception{
        File file = new File(getClass().getResource("/binding/users.json").toURI());
        JsonReader reader = Json.createReader(new FileReader(file));
        JsonArray jsonArray = reader.readArray();
        List<User> users = new ArrayList<>();
        //(int id, String name, String userName, String phone, String email)
        for (int i = 0; i <jsonArray.size() ; i++) {
            JsonNumber id = jsonArray.getJsonObject(i).getJsonNumber("id") ;
            JsonString name = jsonArray.getJsonObject(i).getJsonString("name") ;
            JsonString username = jsonArray.getJsonObject(i).getJsonString("username") ;
            JsonString email = jsonArray.getJsonObject(i).getJsonString("email") ;
            JsonString phone = jsonArray.getJsonObject(i).getJsonString("phone") ;
            User user = new User(id.intValue(),name.toString(),username.toString(),phone.toString(),email.toString());
            users.add(user);
        }

        return users;
    }


    public void produceJson(List<UserInfo> userInfos) throws Exception {

        GsonBuilder gsonBuilder =new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String jsonObject = gson.toJson(userInfos);
        PrintWriter out = new PrintWriter("movie.json");
        out.println(jsonObject);
        System.out.println(jsonObject);

    }
}
