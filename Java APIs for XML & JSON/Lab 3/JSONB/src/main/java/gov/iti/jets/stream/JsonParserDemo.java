package gov.iti.jets.stream;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.iti.jets.lab.Comment;
import gov.iti.jets.lab.Post;
import gov.iti.jets.lab.PostInfo;
import gov.iti.jets.lab.User;
import gov.iti.jets.lab.UserInfo;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class JsonParserDemo {

    public List<User> getUsers() throws Exception{
        File file = new File(getClass().getResource("/binding/users.json").toURI());
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = objectMapper.readValue(new FileReader(file), new TypeReference<List<User>>() {});
        return users;


    }

    

    public List<UserInfo> mapToUserInfo(List<User> users, List<Post> posts , List<Comment> comments ){
        List<UserInfo> usersInfo = new ArrayList<>();
        
        for(User user : users){
            UserInfo userinfo = new UserInfo();
            userinfo.name = user.name;
            userinfo.email = user.email;
            userinfo.userName = user.username;
            userinfo.phone = user.phone;
            List<PostInfo> postsinfo = new ArrayList<>();
            for(int i=0 ; i<posts.size();i++){
                if(user.id == posts.get(i).userId){
                    
                    String title = posts.get(i).title;
                    List<String> commenters = new ArrayList<>();
                    for (int j=0 ; j<comments.size();j++){
                        if(posts.get(i).id == comments.get(j).postId){
                            String email = comments.get(j).email;
                            commenters.add(email);

                        }
                    }
                    PostInfo postInfo = new PostInfo(title, commenters) ;
                    postsinfo.add(postInfo);
                }
            }
            userinfo.posts = postsinfo;
            usersInfo.add(userinfo);
        }
        return usersInfo;
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
//            System.out.println(post);
            postList.add(post);
        }
        return  postList;
    }

    public List<Comment> getComments() throws Exception{
        File file = new File(getClass().getResource("/binding/comments.json").toURI());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Comment> comments = objectMapper.readValue(new FileReader(file), new TypeReference<List<Comment>>() {});
        return comments;
    }

 

    public void consumeJsonInStreamingFashion() throws Exception {
        File file = new File(getClass().getResource("/stream/movie.json").toURI());
        JsonParser parser = Json.createParser(new FileReader(file));

        while (parser.hasNext()) {
            final Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    System.out.println("KEY_NAME \t => \t" + parser.getString());
                    break;
                case VALUE_STRING:
                    System.out.println("VALUE_STRING \t => \t" + parser.getString());
                    break;
                case VALUE_NUMBER:
                    System.out.println("VALUE_NUMBER \t => \t" + parser.getBigDecimal());
                    break;
                case VALUE_TRUE:
                    System.out.println("VALUE_TRUE \t => \t" + true);
                    break;
                case VALUE_FALSE:
                    System.out.println("VALUE_FALSE \t => \t" + false);
                    break;
                case VALUE_NULL:
                    System.out.println("VALUE_NULL \t => \t" + "null");
                    break;
                case END_ARRAY:
                    System.out.println("END_ARRAY \t => \t" + "]");
                    break;
                case END_OBJECT:
                    System.out.println("END_OBJECT \t => \t" + "}");
                    break;
                case START_ARRAY:
                    System.out.println("START_ARRAY \t => \t" + "[");
                    break;
                case START_OBJECT:
                    System.out.println("START_OBJECT \t => \t" + "{");
                    break;
            }
        }

    }

}
