package gov.iti.jets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import gov.iti.jets.lab.Comment;
import gov.iti.jets.lab.Post;
import gov.iti.jets.lab.User;
import gov.iti.jets.lab.UserInfo;
import gov.iti.jets.stream.JsonGeneratorDemo;
import gov.iti.jets.stream.JsonParserDemo;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public class Main {

    public static void main(String[] args) throws Exception {

        JsonParserDemo demo1 = new JsonParserDemo();
        List<User> users = demo1.getUsers();
        List<Post> posts = demo1.getPosts();
        List<Comment> comments = demo1.getComments();
        List<UserInfo> userInfos = demo1.mapToUserInfo(users, posts, comments);
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("result.json");
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userInfos);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(json);
            bw.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.println(userInfos);

    }

}
